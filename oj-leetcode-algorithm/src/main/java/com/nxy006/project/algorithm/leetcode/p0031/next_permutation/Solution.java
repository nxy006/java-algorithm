package com.nxy006.project.algorithm.leetcode.p0031.next_permutation;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 一轮遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 43.58 % of java submissions.
 * Memory   39.3 MB , beats 44.39 % of java submissions.
 * 07/13/2021 22:48
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return ;

        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {                              // 从后向前寻找最长逆序子数列，第一个不符合的数字（即 nums[i]）就是需要修改值的数字
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) j--;                     // 找到逆序范围内大于该值的最小值
                swap(nums, i, j);                                   // 交换
                Arrays.sort(nums, i+1, nums.length);                // 逆序范围内重排序
                return ;
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,3,2]","[1,2,3]");
        caseCheck(new Solution(), "[1,2,3]","[3,2,1]");
        caseCheck(new Solution(), "[1,5,1]","[1,1,5]");
        caseCheck(new Solution(), "[1]","[1]");
        // 自定义用例
        caseCheck(new Solution(), "[5,1,1,2]","[2,5,1,1]");
        caseCheck(new Solution(), "[3,1,2]","[2,3,1]");
        caseCheck(new Solution(), "[5,1,1]","[1,5,1]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr);
        solution.nextPermutation(nums);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expectedStr), nums);
    }
}
