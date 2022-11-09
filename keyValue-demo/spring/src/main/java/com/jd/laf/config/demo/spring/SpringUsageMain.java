package com.jd.laf.config.demo.spring;

import com.jd.laf.config.demo.common.beans.DuccBean;
import com.jd.laf.config.demo.common.beans.SupportConvertTypeSimple;
import com.jd.laf.config.demo.common.bo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bjliuyong on 2018/11/26.
 */
public class SpringUsageMain {

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        DuccBean duccBean = appContext.getBean(DuccBean.class) ;
        SupportConvertTypeSimple simple = appContext.getBean(SupportConvertTypeSimple.class);

        User user = appContext.getBean(User.class);
        while (true) {
            Thread.sleep(2000);
            System.out.println(duccBean);
            System.out.println(user);
            System.out.println(simple);
        }
    }
}
