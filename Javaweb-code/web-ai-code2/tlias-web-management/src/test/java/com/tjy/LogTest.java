package com.tjy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @date 2025/8/6 9:34
 */
public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog() {
        log.debug("开始。。。");

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        log.info("结果是:" + sum);
        log.debug("结束。。。");
    }
}
