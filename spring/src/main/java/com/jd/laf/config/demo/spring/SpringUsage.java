package com.jd.laf.config.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class SpringUsage {

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        Config config = appContext.getBean(Config.class) ;
        while (true) {
            Thread.sleep(2000);
            System.out.println(config);
        }
    }
}
