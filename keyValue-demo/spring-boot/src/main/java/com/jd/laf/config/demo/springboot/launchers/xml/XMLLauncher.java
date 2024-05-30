package com.jd.laf.config.demo.springboot.launchers.xml;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.demo.common.beans.ComplexBean;
import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.DuccPrefixBean;
import com.jd.laf.config.demo.common.bo.EndPoint;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 */
@SpringBootApplication(scanBasePackages = {"com.jd.laf.config.demo.springboot.configbean", "com.jd.laf.config.demo.springboot.listener"})
@ImportResource({
        "classpath:/xml/spring-ducc.xml",
        "classpath:/xml/spring-other.xml"
})
@PropertySource({
        "classpath:/xml/local.properties"
})

public class XMLLauncher {
    private static Logger LOGGER = LoggerFactory.getLogger(XMLLauncher.class);

    @Bean("duccPrefixBean")
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

    @LafValue("endpoints.array")
    public List<EndPoint> endpointListFromArray;

    public List<EndPoint> endpointListFromJson;

    @LafValue("endpoints.json")
    @JsonConverter
    public void setEndpointListFromJson(@JsonConverter(isSupportGeneric = true) List<EndPoint> endPointList) {
        endpointListFromJson = endPointList;
    }

    public static void main(String args[]) {
        try {
            System.setProperty("spring.config.location", "classpath:/xml/");
            ConfigurableApplicationContext applicationContext = SpringApplication.run(XMLLauncher.class, args);

            DuccPrefixBean duccPrefixBean = applicationContext.getBean("duccPrefixBean", DuccPrefixBean.class);
            DuccBean duccBean = applicationContext.getBean("duccBean", DuccBean.class);
            ComplexBean complexBean = applicationContext.getBean(ComplexBean.class);
            XMLLauncher starter = applicationContext.getBean(XMLLauncher.class);

            while (true) {
                LOGGER.info("duccPrefixBean, hashCode: {} : {}", duccPrefixBean.hashCode(), duccPrefixBean);
                LOGGER.info("duccBean, hashCode：{} : {}", duccBean.hashCode(), duccBean);
                LOGGER.info("complexBean, hashCode：{} : {}", complexBean.hashCode(), complexBean);
                LOGGER.info("endPointList from array: {}", starter.endpointListFromArray);
                LOGGER.info("endPointList from json: {}", starter.endpointListFromJson);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
