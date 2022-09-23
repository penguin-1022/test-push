package com.jd.laf.config.demo.dict.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/9/23
 * @since todo
 */
public class DictSpringLauncher {
    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        while (true) {
            Thread.sleep(2000);
            System.out.println("----------" + new Date());
        }
    }
}
