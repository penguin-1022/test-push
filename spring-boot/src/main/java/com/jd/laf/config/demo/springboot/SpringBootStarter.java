package com.jd.laf.config.demo.springboot;

import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.DuccPrefixBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by bjliuyong on 2018/11/26.
 */
@SpringBootApplication
@ConfigurationProperties
@PropertySource({"classpath:/local.properties"})
public class SpringBootStarter  {
    private static Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    @Bean
    @ConfigurationProperties(prefix = "config")
    public DuccPrefixBean duccPrefixBean() {
        return new DuccPrefixBean() ;
    }

    @Bean
    public DuccBean duccBean() {
        return new DuccBean();
    }

    public static void main(String args[]) {
        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarter.class, args);

            DuccPrefixBean duccPrefixBean = applicationContext.getBean("duccPrefixBean", DuccPrefixBean.class);
            DuccBean duccBean = applicationContext.getBean("duccBean", DuccBean.class);

            while (true) {
                LOGGER.info("duccPrefixBean, hashCode: {} : {}", duccPrefixBean.hashCode(), duccPrefixBean);
                LOGGER.info("duccBean, hashCode：{} : {}", duccBean.hashCode(), duccBean);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
