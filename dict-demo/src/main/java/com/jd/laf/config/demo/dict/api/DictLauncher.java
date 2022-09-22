package com.jd.laf.config.demo.dict.api;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Property;
import com.jd.laf.config.Resource;
import com.jd.laf.config.dict.DictDataReceiverRegistry;
import com.jd.laf.config.dict.PrintDictDataReceiver;
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
 * @date 2022/9/17
 * @since todo
 */
public class DictLauncher {
    private static Logger LOG = LoggerFactory.getLogger(DictLauncher.class);

    private long versionOld, versionNew;
    private String prodAppName = "duccadmin";
    private String prodToken = "bd2f271319e349048853701b4dba2512";
    private String prodTreeNS = "ducc_demo", prodTreeCfg = "dict1", prodTreeProfile = "cf-test-1";

    public static void main(String[] args) {
        try {
            ConfiguratorManager configuratorManager = new DictLauncher().ducc();

            synchronized (DictLauncher.class) {
                DictLauncher.class.wait();
            }
            //java进程退出时，可进行关闭
            configuratorManager.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConfiguratorManager ducc() throws Exception {
//        String domain = "ducc.jd.local";
        String domain = "duccserver-yufa.ducc.svc.ht09.n.jd.local";
        String appName = prodAppName;
        String token = prodToken;
        final String namespace = prodTreeNS, config = prodTreeCfg, profile = prodTreeProfile;
        String uri = "ucc://%s:%s@%s/v1/namespace/%s/config/%s/profiles/%s?longPolling=5000&necessary=true&configType=dict";
        uri = String.format(uri, appName, token, domain, namespace, config, profile);

        LOG.info("uri: {}", uri);

        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance();
        //设置appName，jone或者jdos部署可自动获取，无需配置
        configuratorManager.setApplication(appName);

        //resourceName是资源名，命名自定义，多个时不要重复
        String resourceName = "myResourceName1";

        //创建资源对象，此处直接使用ducc远程，Name属性很重要，下面会用到
        Resource resource = new Resource(resourceName, uri);
        final String dictTableName = profile;
        DictDataReceiverRegistry.register(dictTableName, new PrintDictDataReceiver());
        //给配置管理器添加管理的资源
        configuratorManager.addResource(resource);

        //启动之后才可以获取配置
        configuratorManager.start();

        final String printStr = uri;
        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                LOG.info("dict[{}] has been updated and published.", printStr);
                if (configuration != null) {
                    List<Property> properties = configuration.getProperties();
                    for (Property p : properties) {
                        LOG.info("key[{}]: value[{}]", p.getKey(), p.getString());
                    }
                    LOG.info("dict data version: [{}]", configuration.getVersion());
                }
                LOG.info("--------------------------------------------------------------------------------------");
            }
        });

        return configuratorManager;
    }
}
