package com.jd.laf.config.demo.tree.api;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Property;
import com.jd.laf.config.Resource;
import com.jd.laf.config.listener.ConfigurationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/8/20
 * @since todo
 */
public class TreeDemoLauncher {

    private final static Logger logger = LoggerFactory.getLogger(TreeDemoLauncher.class);

    public static void main(String[] args) {

        try {
            ConfiguratorManager configuratorManager = new TreeDemoLauncher().ducc();

            synchronized (TreeDemoLauncher.class) {
                TreeDemoLauncher.class.wait();
            }
            //java进程退出时，可进行关闭
            configuratorManager.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String prodAppName = "duccadmin";
    private String prodToken = "bd2f271319e349048853701b4dba2512";
    private String prodTreeNS = "ducc_demo", prodTreeCfg = "tree1", prodTreeProfile = "profile3";

    public ConfiguratorManager ducc() throws Exception {
        String domain = "ducc.jd.local"; // 使用 ducc 长轮询域名
        String appName = prodAppName;
        String token = prodToken;

        String namespace = prodTreeNS, config = prodTreeCfg, profile = prodTreeProfile;
        // uri格式详解参见：https://cf.jd.com/pages/viewpage.action?pageId=404963382 客户端使用指南->UCC配置服务
        String uri = "ucc://%s:%s@%s/longpolling/v2/namespace/%s/config/%s/profiles/%s?longPolling=60000&necessary=true&configType=tree&path=/,/rate_limit";
        uri = String.format(uri, appName, token, domain, namespace, config, profile);

        logger.info("uri: {}", uri);

        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance();
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

        //resourceName是资源名，命名自定义，多个时不要重复
        final String resourceName = "myTreeDemo1";

        //创建资源对象，此处直接使用ducc远程，Name属性很重要，下面会用到
        Resource resource = new Resource(resourceName, uri);
        //给配置管理器添加管理的资源
        configuratorManager.addResource(resource);

        //可以监听多个Resource
        //configuratorManager.addResource(resource2);

        //启动之后才可以获取配置
        configuratorManager.start();

        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                logger.info("resource: \"{}\" update, conf: {}", resourceName, configuration);
                logger.info("--------------------------------------------------------------------------------------");
            }
        });
        // 获取整个 resource 的配置
        Configuration conf = configuratorManager.getConfiguration(resourceName);
        logger.info("resource: {}, conf: {}", resourceName, conf);

        // 获取单独某个配置的key
        Property p = configuratorManager.getProperty("/rate_limit/interface");
        logger.info("resource: {}, key: /rate_limit/interface, conf: {}", resourceName, p);

        return configuratorManager;
    }
}
