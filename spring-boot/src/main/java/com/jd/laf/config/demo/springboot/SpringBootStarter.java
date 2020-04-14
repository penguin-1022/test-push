package com.jd.laf.config.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by bjliuyong on 2018/11/26.
 */
@SpringBootApplication
public class SpringBootStarter  {

    @Bean
    @ConfigurationProperties(prefix = "conf")
    Config config() {
        return new Config() ;
    }

    public static void main(String args[]) throws Exception {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarter.class , args) ;
        Config config = applicationContext.getBean(Config.class) ;
        ConfigObj configObj = applicationContext.getBean(ConfigObj.class) ;
        while(true) {
            System.out.print(configObj);
            System.out.println(config);
            Thread.sleep(2000L);
        }

    }
}
