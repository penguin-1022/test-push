package com.jd.laf.config.demo.staticconfig;

import com.jd.laf.config.ConfiguratorManager;
import com.jd.laf.config.demo.staticconfig.bean.DemoProperties;
import com.jd.laf.config.demo.staticconfig.bean.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Title: todo <br>
 * <p/>
 * Description: todo
 * <p>
 * company: <a href=www.jd.com>www.jd.com</a>
 *
 * @author <a href=mailto:yangzhiwei@jd.com>cf</a>
 * @date 2022/1/25
 * @since todo
 */
@SpringBootApplication
public class StaticDemoMain {
    public static void main(String args[]) {
        try {
            ConfigurableApplicationContext applicationContext = SpringApplication.run(StaticDemoMain.class, args);
            DemoProperties demoProperties = applicationContext.getBean(DemoProperties.class);
            SystemProperties systemProperties = applicationContext.getBean(SystemProperties.class);

            while (true) {
                System.out.println("systemProperties: " + systemProperties);
                System.out.println("demoProperties: " + demoProperties);
                Thread.sleep(2000L);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
