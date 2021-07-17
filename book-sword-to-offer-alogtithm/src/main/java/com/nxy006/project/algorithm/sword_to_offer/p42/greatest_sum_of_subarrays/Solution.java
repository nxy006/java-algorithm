package com.nxy006.project.algorithm.sword_to_offer.p42.greatest_sum_of_subarrays;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/42_GreatestSumOfSubarrays
 *
 * 动态规划解法：f(n) = max(f(n-1) + nums[n], nums[n])
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 执行用时：1 ms,    在所有 Java 提交中击败了 98.83 % 的用户
 * 内存消耗：44.8 MB, 在所有 Java 提交中击败了 70.30 % 的用户
 * 2021/07/17 23:49
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], ans = sum;
        for(int j = 1; j < nums.length; j++) {
            sum = sum < 0 ? nums[j]:(sum+nums[j]);
            ans = Integer.max(ans, sum);                        // 实际提交代码中，以上两行代码合并为一行
        }
        return ans;
    }
}
