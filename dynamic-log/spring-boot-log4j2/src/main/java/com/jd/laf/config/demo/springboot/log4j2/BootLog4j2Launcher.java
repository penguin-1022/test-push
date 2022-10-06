package com.jd.laf.config.demo.springboot.log4j2;

import com.jd.laf.config.demo.log.common.Config1;
import com.jd.laf.config.demo.log.common.Config2;
import com.jd.laf.config.demo.log.common.Config3;
import com.jd.laf.config.demo.log.common.Config4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * Title: todo <br>
 * <p/>
 * Description:
 * 配置示例地址： http://taishan.jd.com/ducc/web/namespacework?nsId=10382&nsName=ducc_demo&cId=73294&cName=config1&envId=141393&envName=log4j2&defAppId=2769&dataType=0&nsnav=0
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/10/3
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.jd.laf.config.demo.springboot.log4j2")
public class BootLog4j2Launcher {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("spring.config.location", "classpath:/yaml/");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BootLog4j2Launcher.class, args);
        BootLog4j2Launcher launcher = applicationContext.getBean(BootLog4j2Launcher.class);

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
