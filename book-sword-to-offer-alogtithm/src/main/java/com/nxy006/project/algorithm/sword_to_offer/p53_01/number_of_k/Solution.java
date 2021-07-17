package com.nxy006.project.algorithm.sword_to_offer.p53_01.number_of_k;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题53（一）：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组 {1, 2, 3, 3, 3, 3, 4, 5} 和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/53_01_NumberOfK
 *
 * 二分搜索解法
 * 时间复杂度：O(log_n)，空间复杂度：O(1)
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100 % 的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了 48 % 的用户
 * 2021/07/16 23:40
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int l = 0, r = nums.length-1, start = -1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target && (mid == 0 || nums[mid-1] != nums[mid])) {
                start = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if (start == -1) return 0;

        l = 0;
        r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target && (mid == nums.length-1 || nums[mid] != nums[mid+1])) {
                return mid - start + 1;
            } else if (nums[mid] <= target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return 0;
    }
}
