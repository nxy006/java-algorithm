package com.nxy006.project.algorithm.sword_to_offer.p10.fibonacci;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/10_Fibonacci
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 执行用时：50 ms,   在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：34.9 MB, 在所有 Java 提交中击败了 93.85 % 的用户
 * 2021/07/29 23:03
 */
public class Solution {
    private int[] res = new int[101];

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (res[n] != 0) return res[n];

        return res[n] = (fib(n-1) + fib(n-2)) % 1000000007;
    }
}