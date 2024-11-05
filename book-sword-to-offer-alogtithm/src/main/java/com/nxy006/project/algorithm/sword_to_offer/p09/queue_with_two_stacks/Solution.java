package com.nxy006.project.algorithm.sword_to_offer.p09.queue_with_two_stacks;

import java.util.Stack;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 9：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail和 deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/09_QueueWithTwoStacks
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 执行用时：50 ms,   在所有 Java 提交中击败了 80.40 % 的用户
 * 内存消耗：46.7 MB, 在所有 Java 提交中击败了 48.68 % 的用户
 * 2021/07/29 22:52
 */
public class Solution extends SolutionTemplate {
    static class MyCQueue extends SolutionTemplate.CQueue {
        Stack<Integer> in, out;

        public MyCQueue() {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.empty() ? -1 : out.pop();
        }
    }

    public static void main(String[] args) {
        processCaseTest(MyCQueue.class);
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
