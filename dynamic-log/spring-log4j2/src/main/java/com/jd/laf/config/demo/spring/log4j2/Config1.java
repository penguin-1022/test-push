package com.jd.laf.config.demo.spring.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Config1 {
    private static final Logger logger = LogManager.getLogger(Config1.class);


    public Config1() {
    }

    public void loggerLevel() {
        System.out.println("-----");
//        Logger l1 = LogManager.getLogger(Config1.class);
//        Logger l2 = LogManager.getLogger(Config1.class.getName());

//        org.apache.logging.log4j.core.Logger ll = (org.apache.logging.log4j.core.Logger)l2;
//        ll.setLevel(org.apache.logging.log4j.Level.toLevel("warn"));

//        org.apache.logging.log4j.core.config.Configurator.setLevel(Config1.class, org.apache.logging.log4j.Level.toLevel("warn"));

        logger.debug("1 debug level.");
        logger.info("2 info level.");
        logger.warn("3 warning level.");
        logger.error("4 error level.");
        System.out.println("************************************************************");
    }
}
