package com.jd.laf.config.demo.spring.logback;

import com.jd.laf.config.demo.log.common.Config1;
import com.jd.laf.config.demo.log.common.Config2;
import com.jd.laf.config.demo.log.common.Config3;
import com.jd.laf.config.demo.log.common.Config4;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class LogbackDemoLauncher {

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");

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
