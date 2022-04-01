package com.nxy006.project.alogtithm.utils;

import com.nxy006.project.alogtithm.utils.struct.ListNode;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 用例断言工具
 */
public class CaseAssertUtils {
    private static final Logger logger = LogManager.getLogger("Case-Check");

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

    public static <T> void assertEquals(double expected, double actual) {
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

    public static void assertEquals(char[] expected, char[] actual) {
        if (!Arrays.equals(expected, actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    /**
     * 在给定长度范围内检查两个数组是否相等
     */
    public static void assertEqualsWithLength(int[] expected, int[] actual, int length) {
        if (expected == null || actual == null) {
            logger.error("Case Failed! Input cannot null expected was: {}, actual was: {}", expected, actual);
        } else if (expected.length < length || actual.length < length) {
            logger.error("Case Failed! Expected Length: {} but expected was: {}, actual was: {}", length, expected.length, actual.length);
        } else {
            int[] expectedNums = new int[length], actualNums = new int[length];
            System.arraycopy(expected, 0, expectedNums, 0, length);
            System.arraycopy(actual, 0, actualNums, 0, length);
            assertEquals(expectedNums, actualNums);
        }
    }

    public static void assertEqualsIgnoreOrderWithLength(int[] expected, int[] actual, int length) {
        if (expected == null || actual == null) {
            logger.error("Case Failed! Input cannot null expected was: {}, actual was: {}", expected, actual);
        } else if (expected.length < length || actual.length < length) {
            logger.error("Case Failed! Expected Length: {} but expected was: {}, actual was: {}", length, expected.length, actual.length);
        } else {
            int[] expectedNums = new int[length], actualNums = new int[length];
            System.arraycopy(expected, 0, expectedNums, 0, length);
            System.arraycopy(actual, 0, actualNums, 0, length);
            assertEqualsIgnoreOrder(expectedNums, actualNums);
        }
    }

    public static void assertEqualsIgnoreOrder(int[] expected, int[] actual) {
        if (expected != actual && (expected == null || actual == null || expected.length != actual.length)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }

        int[] expectedCopy = Arrays.copyOf(expected, expected.length), actualCopy = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expectedCopy);
        Arrays.sort(actualCopy);
        if (!Arrays.equals(expectedCopy, actualCopy)) {
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

    public static void assertContains(Collection<String> expecteds, String actual) {
        if (!expecteds.contains(actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expecteds, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static void assertContains(Collection<TreeNode> expecteds, TreeNode actual) {
        if (!expecteds.contains(actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expecteds, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static void assertContains(TreeNode[] expecteds, TreeNode actual) {
        assertContains(new ArrayList<>(Arrays.asList(expecteds)), actual);
    }

    public static void assertContains(String[] expecteds, String actual) {
        assertContains(new ArrayList<>(Arrays.asList(expecteds)), actual);
    }

    public static void assertEquals(ListNode expected, ListNode actual) {
        if (expected == null && actual != null) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }

        ListNode tempExpected = expected, tempActual = actual;
        while(tempExpected != null) {
            if (tempActual == null || tempActual.val != tempExpected.val) {
                logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
                return ;
            }
            tempExpected = tempExpected.next;
            tempActual = tempActual.next;
        }
        if (tempActual != null) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static <T> void assertEquals(TreeNode expected, TreeNode actual) {
        if (expected != null && !expected.equals(actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static void assertEquals(int[][] expected, int[][] actual) {
        if (expected.length != actual.length) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        for(int i = 0; i < expected.length; i++) {
            if (!Arrays.equals(expected[i], actual[i])) {
                logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
                return ;
            }
        }

        logger.info("Case PASS!");
    }

    public static void assertEquals(char[][] expected, char[][] actual) {
        if (expected.length != actual.length) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        for(int i = 0; i < expected.length; i++) {
            if (!Arrays.equals(expected[i], actual[i])) {
                logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
                return ;
            }
        }

        logger.info("Case PASS!");
    }

    public static <T> void assertEquals(Object expected, Object actual) {
        if (expected != null && !expected.equals(actual)) {
            logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
            return ;
        }
        logger.info("Case PASS!");
    }

    public static <T> void assertContains(int[] expected, int actual) {
        for(int num : expected) {
            if (num == actual) {
                logger.info("Case PASS!");
                return;
            }
        }
        logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
    }

}
