package com.nxy006.project.algorithm.sword_to_offer.p09.queue_with_two_stacks;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 9：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail和 deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/09_QueueWithTwoStacks
 */
public class SolutionTemplate {
    // ---------------------------------------------------------- 结构定义 ----------------------------------------------------------- //

    /**
     * 本题原题是 Char 队列，为方便使用替换为 int 队列
     */
    static abstract class CQueue {
        abstract void appendTail(int value);

        abstract int deleteHead();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(Class klass) {
        // 书籍用例
        caseCheck(klass, "[0,0,0,1,2,0,3,0,4,5]",
                "[\"appendTail\",\"appendTail\",\"appendTail\",\"deleteHead\",\"deleteHead\",\"appendTail\",\"deleteHead\",\"appendTail\",\"deleteHead\",\"deleteHead\"]",
                "[1,2,3,0,0,4,0,5,0,0]");
    }

    public static void caseCheck(Class<CQueue> klass, String expectedStr, String commandsStr, String paramsStr) {
        int[] expected = StructConvertUtils.convertToIntArray(expectedStr);
        String[] commands = StructConvertUtils.convertToStringArray(commandsStr);
        int[] params = StructConvertUtils.convertToIntArray(paramsStr);
        if (expected.length != commands.length || expected.length != params.length) {
            throw new RuntimeException("无效的用例");
        }

        try {
            CQueue cQueue = klass.newInstance();
            for(int i = 0; i < commands.length; i++) {
                switch (commands[i]) {
                    case "appendTail":
                        cQueue.appendTail(params[i]);
                        break;
                    case "deleteHead":
                        CaseAssertUtils.assertEquals(expected[i], cQueue.deleteHead());
                        break;
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
