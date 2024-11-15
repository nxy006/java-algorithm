package com.nxy006.project.alogtithm.utils;

import com.nxy006.project.alogtithm.utils.struct.ListNode;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 用例断言工具
 */
public class CaseAssertUtils {
    private static final Logger logger = LogManager.getLogger("CaseResult");

    private static ExecutorService executorService;
    private static final ThreadLocal<AtomicInteger> caseCounter = new ThreadLocal<>();
    static {
        caseCounter.set(new AtomicInteger(1));
    }

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

    public static void resetCaseCount() {
        caseCounter.set(new AtomicInteger(1));
    }

    public static int incrementAndGetCaseCount() {
        return caseCounter.get().getAndIncrement();
    }

    /**
     * 施工调试中
     */
    public static <T> void assertEquals(T expected, SolutionProcessor<T> solutionProcessor) {
        processAndAssert(expected, solutionProcessor, 1000, ResultAsserter.EQUALS_ASSERTER);
    }

    /**
     * 施工调试中
     */
    public static <T> void processAndAssert(T expected, SolutionProcessor<T> solutionProcessor, long timeout,
                                            ResultAsserter<T> resultAsserter) {
        // 每次创建是为了能 shutdown 线程池，不然进程不会自动关闭，暂时没有更好的方法
        // 另外这样也能解决执行死循环时占用线程池的问题
        executorService = Executors.newFixedThreadPool(1);

        FutureTask<CaseResult> futureTask = new FutureTask<>(() -> {
            try {
                long startTime = System.currentTimeMillis();
                T result = solutionProcessor.process();
                long duration = System.currentTimeMillis() - startTime;
                if (duration > timeout) {
                    return new CaseResult(CaseResultEnum.TLE, duration);
                }

                if (resultAsserter.assertResult(expected, result)) {
                    return new CaseResult(CaseResultEnum.AC, duration);
                }
                return new CaseResult(CaseResultEnum.WA,
                        "Expected: " + PrettyPrintUtils.toPrettyString(expected) + " but was: " + PrettyPrintUtils.toPrettyString(result), duration);
            } catch (Exception ex) {
                logger.error("执行过程异常", ex);
                return CaseResult.WA;
            }
        });

        CaseResult result;
        try {
            executorService.execute(futureTask);
            result = futureTask.get(timeout*2, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            result = CaseResult.TLE;
        } catch (Exception e) {
            result = CaseResult.SYSTEM_ERROR;
        } finally {
            executorService.shutdown();
        }

        // 打印用例结果
        logger.info("Case {} {} ({}{}){}",
                incrementAndGetCaseCount(),
                result.getResult().getDescription(),
                result.getResult().getCode(),
                result.getDuration() != -1 ? ", " + result.getDuration() + "ms" : "",
                StringUtils.isNotEmpty(result.getMessage()) ? ": " + result.getMessage() : "");
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

    public static <T> void assertContains(int[][] expected, int[] actual) {
        boolean isMatch = false;
        for(int[] nums : expected) {
            isMatch = Arrays.equals(nums, actual);
            if (isMatch) {
                logger.info("Case PASS!");
                return ;
            }
        }
        logger.error("Case Failed! Expected: {} but was: {}", expected, actual);
    }



    public interface ResultAsserter<T> {
        boolean assertResult(T expected, T result);

        ResultAsserter EQUALS_ASSERTER = new ResultAsserter<Object>() {
            @Override
            public boolean assertResult(Object expected, Object result) {
                return CompareUtils.assertEqualsCommon(expected, result);
            }
        };
    }

    public interface SolutionProcessor<T> {
        T process();
    }

    private static class CaseResult {
        CaseResultEnum result;      // 用例执行结果
        String message;             // 消息，一般是错误内容
        long duration = -1;         // 实际执行时间

        public static CaseResult AC = new CaseResult(CaseResultEnum.AC);
        public static CaseResult WA = new CaseResult(CaseResultEnum.WA);
        public static CaseResult TLE = new CaseResult(CaseResultEnum.TLE);
        public static CaseResult RE = new CaseResult(CaseResultEnum.RE);
        public static CaseResult SYSTEM_ERROR = new CaseResult(CaseResultEnum.SYSTEM_ERROR);

        public CaseResult(CaseResultEnum result) {
            this.result = result;
        }

        public CaseResult(CaseResultEnum result, long duration) {
            this.duration = duration;
            this.result = result;
        }

        public CaseResult(CaseResultEnum result, String message) {
            this.result = result;
            this.message = message;
        }

        public CaseResult(CaseResultEnum result, String message, long duration) {
            this.result = result;
            this.message = message;
            this.duration = duration;
        }

        public CaseResultEnum getResult() {
            return result;
        }

        public String getMessage() {
            return message;
        }

        public long getDuration() {
            return duration;
        }
    }

    public enum CaseResultEnum {
        AC("Accepted", "用例通过"),
        WA("Wrong Answer", "错误答案"),
        TLE("Time Limit Exceed","时间超限"),
        RE("Runtime Error", "运行错误"),
        SYSTEM_ERROR("System Error", "评测系统异常")
        ;

        final String code;
        final String description;

        CaseResultEnum(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

}
