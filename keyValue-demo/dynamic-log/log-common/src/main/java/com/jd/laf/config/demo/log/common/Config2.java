package com.jd.laf.config.demo.log.common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class Config2 {
    private static final Logger logger = LoggerFactory.getLogger(Config2.class);

    public Config2() {
    }

    public void loggerLevel() {
        logger.debug("1 debug level.");
        logger.info("2 info level.");
        logger.warn("3 warning level.");
        logger.error("4 error level.");
        System.out.println("************************************************************");
    }
}
