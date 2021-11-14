package com.jd.laf.config.demo.spring.logback;


import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringUsage {

    // wiki地址：https://git.jd.com/laf/laf-config/wikis/动态日志配置

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        Config config = appContext.getBean(Config.class) ;
        while (true) {
            config.loggerLevel();
            Thread.sleep(2000);
        }
    }
}
