package com.jd.laf.config.demo.springboot;

import com.jd.laf.config.demo.springboot.configbean.Demo4ComponentBean;
import com.jd.laf.config.demo.springboot.configbean.Demo4SpringConfigurationPropertiesModel;
import com.jd.laf.config.demo.springboot.listener.bybean.DemoPropertyListener;
import com.jd.laf.config.demo.springboot.listener.byproperty.ConfigBeanListener;
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
            ConfigBeanListener configBeanListener = applicationContext.getBean(ConfigBeanListener.class);

            DemoPropertyListener propertyListener = applicationContext.getBean(DemoPropertyListener.class);

            while (true) {
                System.out.println("通过 spring boot @ConfigurationProperties 注解定义的 ducc 配置类： " + demo4SpringConfigurationPropertiesModel);
                System.out.println("通过 @Component 注解定义的 ducc 配置类： " + demo4ComponentBean);
                System.out.println("通过 @Component 注解定义的 ducc 配置类： " + demo4ComponentBean.getDateBeanList());
                System.out.println("通过 application.properties 配置的 ducc 配置属性监听器： " + configBeanListener);
                System.out.println("通过集成 ducc PropertyListener 接口，实现的配置属性监听器： " + propertyListener);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
