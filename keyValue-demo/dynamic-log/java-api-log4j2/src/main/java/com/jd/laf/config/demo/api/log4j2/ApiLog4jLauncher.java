package com.jd.laf.config.demo.api.log4j2;

import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.Resource;
import com.jd.laf.config.demo.log.common.Config1;
import com.jd.laf.config.demo.log.common.Config2;
import com.jd.laf.config.demo.log.common.Config3;
import com.jd.laf.config.demo.log.common.Config4;
import com.jd.laf.config.logging.LogLevelEnableListener;
import com.jd.laf.config.logging.LogLevelListener;

import java.util.concurrent.TimeUnit;

import static com.jd.laf.config.logging.Log4jLevelUpdaterFactory.LogType.LOG4J2;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/10/6
 * @since todo
 */
public class ApiLog4jLauncher {

    private static void watchLogLevel() throws Exception {
        String appName = "myapp_test" ;
        String uri = "ucc://duccadmin:bd2f271319e349048853701b4dba2512@ducc.jd.local/v1/namespace/ducc_demo/config/logging/profiles/log4j2?longPolling=60000&necessary=true";
        //创建ConfiguratorManager 实例，有1个就可以
        ConfiguratorManager configuratorManager = ConfiguratorManager.getInstance() ;
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

        //添加监听器，顺序不能换
        configuratorManager.addListener(new LogLevelEnableListener(true));
        configuratorManager.addListener(LogLevelListener.instance("logger.level", LOG4J2));
    }

    public static void main(String[] args) throws Exception {
        watchLogLevel();

        Config1 config1 = new Config1();
        Config2 config2 = new Config2();
        Config3 config3 = new Config3();
        Config4 config4 = new Config4();

        while (true) {
            config1.loggerLevel();
            config2.loggerLevel();
            config3.loggerLevel();
            config4.loggerLevel();
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
