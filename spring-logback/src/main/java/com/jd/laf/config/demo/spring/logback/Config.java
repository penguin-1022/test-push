package com.jd.laf.config.demo.spring.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    public Config() {
    }

    public void loggerLevel() {
        logger.debug("1 debug level.");
        logger.info("2 info level.");
        logger.warn("3 warning level.");
        logger.error("4 error level.");
    }
}
