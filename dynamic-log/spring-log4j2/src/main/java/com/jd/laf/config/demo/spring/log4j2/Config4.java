package com.jd.laf.config.demo.spring.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Config4 {
    private static final Logger logger = LogManager.getLogger(Config4.class);

    public Config4() {
    }

    public void loggerLevel() {
        logger.debug("1 debug level.");
        logger.info("2 info level.");
        logger.warn("3 warning level.");
        logger.error("4 error level.");
        System.out.println("************************************************************");
    }
}
