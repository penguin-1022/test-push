package com.jd.laf.config.demo.spring.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Config3 {
    private static final Logger logger = LoggerFactory.getLogger(Config3.class);

    public Config3() {
    }

    public void loggerLevel() {
        logger.debug("1 debug level.");
        logger.info("2 info level.");
        logger.warn("3 warning level.");
        logger.error("4 error level.");
        System.out.println("************************************************************");
    }
}
