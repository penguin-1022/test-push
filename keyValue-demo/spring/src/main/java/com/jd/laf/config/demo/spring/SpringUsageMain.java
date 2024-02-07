package com.jd.laf.config.demo.spring;

import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.SupportConvertTypeSimple;
import com.jd.laf.config.demo.common.bo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUsageMain {

    private static Logger LOG = LoggerFactory.getLogger(SpringUsageMain.class);

    public static void main(String args[]) throws Exception {
        //初始化 spring 容器
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");

        /**
         * 容器中的 bean，查看这个 bean 的源码可以发现 DUCC SDK 支持的常用注解和使用方式。
         * DUCC 推荐使用的注解： @LafValue
         * 注意： 尽管 DUCC SDK 兼容了 spring 的 @Value 注解，但是这对底层框架是有侵入的，不建议使用 spring 注解监听 DUCC 配置。
         */
        DuccBean duccBean = appContext.getBean(DuccBean.class) ;

        /**
         *
         */
        SupportConvertTypeSimple simple = appContext.getBean(SupportConvertTypeSimple.class);

        User user = appContext.getBean(User.class);
        Thread.sleep(2000);

        while (true) {
            LOG.info("{}", duccBean);
            LOG.info("{}", user);
            LOG.info("{}", simple);

            Thread.sleep(2000);
        }
    }
}
