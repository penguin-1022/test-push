package com.jd.laf.config.demo.spring.log4j2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Log4j2DemoLauncher {

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        Config1 config1 = appContext.getBean(Config1.class);
        Config2 config2 = appContext.getBean(Config2.class);
        Config3 config3 = appContext.getBean(Config3.class);
        Config4 config4 = appContext.getBean(Config4.class);

        while (true) {
            config1.loggerLevel();
            config2.loggerLevel();
            config3.loggerLevel();
            config4.loggerLevel();
            System.out.println("\n\n\n");
            Thread.sleep(3000);
        }
    }
}
