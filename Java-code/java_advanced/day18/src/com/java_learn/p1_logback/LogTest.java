package com.java_learn.p1_logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 23:04
 */
public class LogTest {
    public static void main(String[] args) {
        // 获取日志对象使用, 参数一般为当前类.class
        Logger logger = LoggerFactory.getLogger("LogTest.class");

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
