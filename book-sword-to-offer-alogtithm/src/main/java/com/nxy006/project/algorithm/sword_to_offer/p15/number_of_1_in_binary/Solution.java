package com.nxy006.project.algorithm.sword_to_offer.p15.number_of_1_in_binary;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 *       把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/15_NumberOf1InBinary
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：35.5 MB, 在所有 Java 提交中击败了  10.79 % 的用户
 * 2021/08/20 14:37
 */
public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while(n != 0) {
            n &= n-1;
            sum++;
        }
        return sum;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // Leetcode-CN 题目示例
        CaseAssertUtils.assertEquals(3, new Solution().hammingWeight(11));
        CaseAssertUtils.assertEquals(1, new Solution().hammingWeight(128));
        CaseAssertUtils.assertEquals(31, new Solution().hammingWeight(-3));
        // 书籍用例
        CaseAssertUtils.assertEquals(0, new Solution().hammingWeight(0));
        CaseAssertUtils.assertEquals(1, new Solution().hammingWeight(1));
        CaseAssertUtils.assertEquals(2, new Solution().hammingWeight(10));
        CaseAssertUtils.assertEquals(31, new Solution().hammingWeight(0x7FFFFFFF));
        CaseAssertUtils.assertEquals(32, new Solution().hammingWeight(0xFFFFFFFF));
        CaseAssertUtils.assertEquals(1, new Solution().hammingWeight(0x80000000));
    }
}
