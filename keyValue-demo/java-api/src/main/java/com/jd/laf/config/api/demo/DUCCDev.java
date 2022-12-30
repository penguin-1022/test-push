package com.jd.laf.config.api.demo;

import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Resource;
import com.jd.laf.config.listener.ConfigurationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/12/14
 * @since todo
 */
public class DUCCDev {
    private final static Logger logger = LoggerFactory.getLogger(DUCCDev.class);

    public static void main(String args[]) throws Exception {

        ConfiguratorManager configuratorManager = new DUCCDev().ducc();

        synchronized (DUCCDev.class) {
            DUCCDev.class.wait();
        }

        //java进程退出时，可进行关闭
        configuratorManager.stop();
    }

    public ConfiguratorManager ducc() throws Exception {
        String appName;
        String token;
        String subUri;

        String format = "ucc://%s:%s@%s";
        //-- 预发
        appName = "jdos_ducc-dict-server";
        token = "6c8eea7c227d42048aa29046114df268";
        subUri = "ducc-server-test-duccservercstpre1.sys-try.svc.lf09.n.jd.local/v1/namespace/cf_test/config/cfg1/profiles/compress2?longPolling=60000&necessary=true";

        //-- 测试环境
//        appName = "jdos_duccadmin";
//        token = "7251d2bc9b104b2ca49ef91491ac3c76";
//        subUri = "test.ducc.jd.local/v1/namespace/ducc_cf/config/config-a/profiles/profile1?longPolling=60000&necessary=true";

        //-- 本地环境
//        appName = "jdos_duccadmin";
//        token = "7251d2bc9b104b2ca49ef91491ac3c76";
//        subUri = "127.0.0.1:10020/v1/namespace/ducc_cf/config/config-a/profiles/profile1?longPolling=5000&necessary=true";

        //-- 线上环境
//        appName = "duccadmin";
//        token = "bd2f271319e349048853701b4dba2512";
//        subUri = "ducc.jd.local/v1/namespace/ducc_cf/config/admin/profiles/common?longPolling=60000&necessary=true";


        String uri = String.format(format, appName, token, subUri);
//        uri = "ucc://jdos_app-try-worker:ca540a8806d14628b62a11ca7e21553b@ducc.jd.local/v1/namespace/cst1/config/cst1/profiles/cst1?longPolling=60000&necessary=false";
//        uri = "ucc://jdos_app-try-worker:ca540a8806d14628b62a11ca7e21553b@ducc.jd.local/v1/namespace/self_prod_ns/config/kv_config/profiles/p1?longPolling=60000&necessary=true";

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

        //启动之后才可以获取配置
        configuratorManager.start();

        //添加监听器，resource维度的监听器
        configuratorManager.addListener(new ConfigurationListener.CustomConfigurationListener(resourceName) {
            @Override
            public void onUpdate(Configuration configuration) {
                logger.info("on configuration update-------------------------------------");
                if (Optional.of(configuration.getProperties()) != null) {
                    configuration.getProperties().stream().forEach(property ->{
                        logger.info("{} ---> {}", property.getKey(), property.getValue());
                    });
                }
                logger.info("------------------------------------\n\n\n");
            }
        });

        return configuratorManager;
    }
}
