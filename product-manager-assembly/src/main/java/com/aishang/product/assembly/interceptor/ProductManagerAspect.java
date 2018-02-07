package com.aishang.product.assembly.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProductManagerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    protected void info(String log, Object... arguments) {
        logger.info(log, arguments);
    }


    protected void debug(String log, Object... arguments) {
        logger.debug(log, arguments);
    }


    protected void error(String log, Object... arguments) {
        logger.error(log, arguments);
    }

}
