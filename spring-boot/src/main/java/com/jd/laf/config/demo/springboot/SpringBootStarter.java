package com.jd.laf.config.demo.springboot;

import com.jd.laf.config.demo.springboot.configbean.Demo4ComponentBean;
import com.jd.laf.config.demo.springboot.configbean.Demo4SpringConfigurationPropertiesModel;
import com.jd.laf.config.demo.springboot.listener.DemoPropertyListener;
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
    public Demo4SpringConfigurationPropertiesModel config() {
        return new Demo4SpringConfigurationPropertiesModel() ;
    }

    public static void main(String args[]) {
        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarter.class, args);

            Demo4SpringConfigurationPropertiesModel demo4SpringConfigurationPropertiesModel =
                    applicationContext.getBean(Demo4SpringConfigurationPropertiesModel.class);

            Demo4ComponentBean demo4ComponentBean = applicationContext.getBean(Demo4ComponentBean.class);
            DemoPropertyListener demoPropertyListener = (DemoPropertyListener) applicationContext.getBean("demoPropertyListener");

            while (true) {
                System.out.println(demo4SpringConfigurationPropertiesModel);
                System.out.println(demo4ComponentBean);
                System.out.println(demoPropertyListener);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
