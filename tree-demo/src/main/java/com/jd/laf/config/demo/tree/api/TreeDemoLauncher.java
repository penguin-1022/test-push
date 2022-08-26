package com.jd.laf.config.demo.tree.api;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Resource;
import com.jd.laf.config.listener.ConfigurationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public ConfiguratorManager ducc() throws Exception {
//        String domain = "ducc.jd.local";
        String domain = "127.0.0.1:10020";
        String appName = "myapp_test";
        String token = "0bb15faf-a36d-40cd-9a93-88074eb920b0";
        String namespace = "cf_test", config = "tree1", profile = "profile2";
        //uri格式详解参见：https://git.jd.com/laf/laf-config/wikis/客户端使用指南->UCC配置服务
        //resource uri format => ucc://{app_name}:{token}@{domain}:{port}/v1/namespace/{namespace}/config/{configuration}/profiles/{profiles}?longPolling=60000&necessary=false
//        String uri = "ucc://myapp_test:0bb15faf-a36d-40cd-9a93-88074eb920b0@test.ducc.jd.local/v1/namespace/ducc_admin/config/admin/profiles/common?longPolling=60000&necessary=false" ;
//        String uri = "ucc://duccadmin:bd2f271319e349048853701b4dba2512@ducc.jd.local/v1/namespace/ducc_demo/config/config1/profiles/profile2?longPolling=60000&necessary=true";
//        String uri = "ucc://%s:%s@%s/longpolling/v2/namespace/%s/config/%s/profiles/%s?longPolling=60000&necessary=true&path=/,/a";
//        uri = String.format(uri, appName, token, domain, namespace, config, profile);
        String uri = "ucc://jdos_duccadmin:7251d2bc9b104b2ca49ef91491ac3c76@127.0.0.1:10020" +
                "/longpolling/v2/namespace/treeTest/config/config-a/profiles/test?longPolling=60000&necessary=false" +
                "&path=/json,/level1";

        logger.info("uri: {}", uri);

        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance();
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

        //resourceName是资源名，命名自定义，多个时不要重复
        String resourceName = "myResourceName";

        //创建资源对象，此处直接使用ducc远程，Name属性很重要，下面会用到
        Resource resource = new Resource(resourceName, uri);
        //给配置管理器添加管理的资源
        configuratorManager.addResource(resource);

        //可以监听多个Resource
        //configuratorManager.addResource(resource); 调用多次

        //启动之后才可以获取配置
        configuratorManager.start();

        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                logger.info("{}", configuration);
                logger.info("{}", configuration.getProperties());

            }
        });

        return configuratorManager;
    }
}
