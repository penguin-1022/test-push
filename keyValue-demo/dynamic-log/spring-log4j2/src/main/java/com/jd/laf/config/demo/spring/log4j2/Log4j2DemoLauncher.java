package com.jd.laf.config.demo.spring.log4j2;

import com.jd.laf.config.demo.log.common.Config1;
import com.jd.laf.config.demo.log.common.Config2;
import com.jd.laf.config.demo.log.common.Config3;
import com.jd.laf.config.demo.log.common.Config4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class Log4j2DemoLauncher {
    private static Logger LOG = LoggerFactory.getLogger(Log4j2DemoLauncher.class);
    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");

        Config1 config1 = new Config1();
        Config2 config2 = new Config2();
        Config3 config3 = new Config3();
        Config4 config4 = new Config4();

        while (true) {
            config1.loggerLevel();
            config2.loggerLevel();
            config3.loggerLevel();
            config4.loggerLevel();

            LOG.error("---------------------------------------------------------------------------------------");
            LOG.debug("======================debug===================================");
            LOG.info("=======================info==================================");
            LOG.warn("=======================warn==================================");
            LOG.error("=======================error==================================");

            TimeUnit.SECONDS.sleep(3);
        }
    }
}
