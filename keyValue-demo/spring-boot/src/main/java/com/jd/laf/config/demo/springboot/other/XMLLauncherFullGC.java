package com.jd.laf.config.demo.springboot.other;

import com.jd.laf.binding.annotation.JsonConverter;
import com.jd.laf.config.Configuration;
import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.demo.common.beans.ComplexBean;
import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.DuccPrefixBean;
import com.jd.laf.config.demo.common.bo.EndPoint;
import com.jd.laf.config.listener.ConfigurationListener;
import com.jd.laf.config.spring.annotation.LafValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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
 * @date 2022/9/7
 * @since todo
 */

@SpringBootApplication(scanBasePackages = {"com.jd.laf.config.demo.springboot.configbean", "com.jd.laf.config.demo.springboot.listener"})
@ImportResource({
        "classpath:/fgc/spring-ducc.xml",
        "classpath:/fgc/spring-other.xml"
})
@PropertySource({
        "classpath:/fgc/local.properties"
})
public class XMLLauncherFullGC {
    private static Logger LOGGER = LoggerFactory.getLogger(XMLLauncherFullGC.class);

    private static DuccBean duccBean1 = null, duccBean2 = null, duccBean3 = null;
    private static ComplexBean complexBean1 = null;
    private static DuccPrefixBean duccPrefixBean1 = null;
    private static int counter = 0;
    private static ConfigurableApplicationContext applicationContext;

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
    public void setEndpointListFromJson(@JsonConverter List<EndPoint> endPointList) {
        endpointListFromJson = endPointList;
    }

    public static void main(String args[]) {
        try {
            System.setProperty("spring.config.location", "classpath:/fgc/");
            applicationContext = SpringApplication.run(XMLLauncherFullGC.class, args);

            DuccPrefixBean duccPrefixBean = applicationContext.getBean("duccPrefixBean", DuccPrefixBean.class);
            DuccBean duccBean = applicationContext.getBean("duccBean", DuccBean.class);
            ComplexBean complexBean = applicationContext.getBean(ComplexBean.class);
            XMLLauncherFullGC starter = applicationContext.getBean(XMLLauncherFullGC.class);

            {
                DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
                String name = "CustomConfigurationListener-1";
                ConfigurationListener.CustomConfigurationListener listener = new ConfigurationListener.CustomConfigurationListener("ucc_test") {
                    @Override
                    public void onUpdate(Configuration configuration) {
                        System.out.println("custom config listener on update: " + configuration);
                    }
                };

                beanFactory.registerSingleton(name, listener);
                ConfiguratorManager manager = applicationContext.getBean(ConfiguratorManager.class);
                manager.addListener(listener);
            }

            while (true) {
                createSpringBeans();

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

    private static void createSpringBeans() {
        if (duccBean1 == null) {
            duccBean1 = applicationContext.getBeanFactory().createBean(DuccBean.class);
        }

        {
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();

            //注册Bean定义，容器根据定义返回bean
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DuccBean.class);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            String name = "duccbean-" + (counter++);
            beanFactory.registerBeanDefinition(name, beanDefinition);
            //注册bean实例
            DuccBean duccBean4 = (DuccBean) beanFactory.getBean(name);
            System.out.println("duccBean4: " + duccBean4.hashCode() + ", " + duccBean4);

            if (counter == 3) {
                duccBean3 = duccBean4;
            } else {
                beanFactory.removeBeanDefinition(name);
            }

            System.out.println("duccBean1: " + duccBean1);
            System.out.println("duccBean2: " + duccBean2);
            System.out.println("duccBean3: " + duccBean3);
        }


        {
            //ComplexBean
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();

            //注册Bean定义，容器根据定义返回bean
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ComplexBean.class);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            String name = "ComplexBean-" + (counter++);
            beanFactory.registerBeanDefinition(name, beanDefinition);
            //注册bean实例
            ComplexBean complexBean = (ComplexBean) beanFactory.getBean(name);


            applicationContext.getBeanFactory().applyBeanPostProcessorsBeforeInitialization(complexBean, name);

            System.out.println("ComplexBean: " + complexBean.hashCode() + ", " + complexBean);

            if (counter == 2) {
                complexBean1 = complexBean;
            } else {
                beanFactory.removeBeanDefinition(name);
            }
            System.out.println("complexBean: " + complexBean);
            System.out.println("complexBean1: " + complexBean1);
        }

        {
            //DuccPrefixBean
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();

            //注册Bean定义，容器根据定义返回bean
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DuccPrefixBean.class);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            String name = "DuccPrefixBean-" + (counter++);
            beanFactory.registerBeanDefinition(name, beanDefinition);
            //注册bean实例
            DuccPrefixBean bean = (DuccPrefixBean) beanFactory.getBean(name);


            applicationContext.getBeanFactory().applyBeanPostProcessorsBeforeInitialization(bean, name);

            System.out.println("DuccPrefixBean: " + bean.hashCode() + ", " + bean);

            if (counter == 2) {
                duccPrefixBean1 = bean;
            } else {
                beanFactory.removeBeanDefinition(name);
            }
            System.out.println("DuccPrefixBean: " + bean);
            System.out.println("duccPrefixBean1: " + duccPrefixBean1);
        }
        System.gc();
    }
}
