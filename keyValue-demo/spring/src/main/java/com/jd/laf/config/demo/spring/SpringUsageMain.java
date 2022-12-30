package com.jd.laf.config.demo.spring;

import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.SupportConvertTypeSimple;
import com.jd.laf.config.demo.common.bo.User;
import com.jd.laf.config.demo.spring.jsf.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class SpringUsageMain {

    private static Logger LOG = LoggerFactory.getLogger(SpringUsageMain.class);

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        HelloService helloService = (HelloService) appContext.getBean("helloService");

        DuccBean duccBean = appContext.getBean(DuccBean.class) ;
        SupportConvertTypeSimple simple = appContext.getBean(SupportConvertTypeSimple.class);
        ConfiguratorManager manager = appContext.getBean(ConfiguratorManager.class);

        User user = appContext.getBean(User.class);
        Thread.sleep(2000);

        while (true) {
            Thread.sleep(2000);
            LOG.info("{}", duccBean);
            LOG.info("{}", user);
            LOG.info("{}", simple);
            LOG.info("=========================================================");
        }
    }
}
