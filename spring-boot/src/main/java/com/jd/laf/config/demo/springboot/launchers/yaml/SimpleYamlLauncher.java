package com.jd.laf.config.demo.springboot.launchers.yaml;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.common.beans.ComplexBean;
import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.DuccPrefixBean;
import com.jd.laf.config.demo.common.beans.MyBean1;
import com.jd.laf.config.demo.common.bo.EndPoint;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * Created by bjliuyong on 2018/11/26.
 */
@SpringBootApplication(scanBasePackages = {"com.jd.laf.config.demo.springboot.configbean", "com.jd.laf.config.demo.springboot.listener"})
@PropertySource({"classpath:/local.properties"})
public class SimpleYamlLauncher {
    private static Logger LOGGER = LoggerFactory.getLogger(SimpleYamlLauncher.class);

    @Bean
    @ConfigurationProperties(prefix = "config")
    public DuccPrefixBean duccPrefixBean() {
        return new DuccPrefixBean() ;
    }

    @Bean
    public DuccBean duccBean() {
        return new DuccBean();
    }

    @Bean
    public ComplexBean complexBean() {
        return new ComplexBean();
    }

    @Bean
    public MyBean1 myBean1() {return new MyBean1();};

    @LafValue("endpoints.array")
    public List<EndPoint> endpointListFromArray;

    public List<EndPoint> endpointListFromJson;

    @LafValue("endpoints.json")
    @JsonConverter
    public void setEndpointListFromJson(@JsonConverter List<EndPoint> endPointList) {
        endpointListFromJson = endPointList;
    }

    public static void main(String args[]) {
        try {
            System.setProperty("spring.config.location", "classpath:/simple/yaml/");
            ConfigurableApplicationContext applicationContext = SpringApplication.run(SimpleYamlLauncher.class, args);

            DuccPrefixBean duccPrefixBean = applicationContext.getBean("duccPrefixBean", DuccPrefixBean.class);
            DuccBean duccBean = applicationContext.getBean("duccBean", DuccBean.class);
            ComplexBean complexBean = applicationContext.getBean(ComplexBean.class);
            SimpleYamlLauncher starter = applicationContext.getBean(SimpleYamlLauncher.class);
            MyBean1 myBean1 = applicationContext.getBean(MyBean1.class);

            while (true) {
                LOGGER.info("duccPrefixBean, hashCode: {} : {}", duccPrefixBean.hashCode(), duccPrefixBean);
                LOGGER.info("duccBean, hashCode：{} : {}", duccBean.hashCode(), duccBean);
                LOGGER.info("complexBean, hashCode：{} : {}", complexBean.hashCode(), complexBean);
                LOGGER.info("endPointList from array: {}", starter.endpointListFromArray);
                LOGGER.info("endPointList from json: {}", starter.endpointListFromJson);
                LOGGER.info("myBean1: {}", myBean1);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
