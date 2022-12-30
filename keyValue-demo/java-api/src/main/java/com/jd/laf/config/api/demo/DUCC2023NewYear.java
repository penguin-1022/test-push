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
public class DUCC2023NewYear {
    private final static Logger logger = LoggerFactory.getLogger(DUCC2023NewYear.class);

    public static void main(String args[]) throws Exception {

        ConfiguratorManager configuratorManager = new DUCC2023NewYear().ducc();

        synchronized (DUCC2023NewYear.class) {
            DUCC2023NewYear.class.wait();
        }

        //java进程退出时，可进行关闭
        configuratorManager.stop();
    }

    public ConfiguratorManager ducc() throws Exception {
        String appName;
        String token;
        String subUri;

        String format = "ucc://%s:%s@%s";

        appName = "ducctestApp";
        token = "92b63f7198a2443d86c68a7a08063015";
        subUri = "x.ducc.jd.local/v1/namespace/ducctest/config/config1/profiles/profile1?longPolling=60000&necessary=true";

        String uri = String.format(format, appName, token, subUri);

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
