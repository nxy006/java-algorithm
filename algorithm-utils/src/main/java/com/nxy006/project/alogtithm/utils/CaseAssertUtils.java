package com.nxy006.project.alogtithm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * 用例断言工具
 */
public class CaseAssertUtils {
    private static final Logger logger = LogManager.getLogger();

    public static void assertTrue(boolean condition) {
        if (!condition) {
            logger.error("Case Failed! Expected: <true> but was: <false>");
            return ;
        }
        logger.info("Case PASS!");
    }

    public static <T> void assertEqualsIgnoreOrder(List<T> expected, List<T> actual) {
        if (!CompareUtils.compareIgnoreOrder(expected, actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static <T> void assertEquals(int expected, int actual) {
        if (expected != actual) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static void assertEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static void assertEquals(String expected, String actual) {
        if (expected == null && actual != null || expected != null && !expected.equals(actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }
}
