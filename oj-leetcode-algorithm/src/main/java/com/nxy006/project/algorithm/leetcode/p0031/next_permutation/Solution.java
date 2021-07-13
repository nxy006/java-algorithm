package com.nxy006.project.algorithm.leetcode.p0031.next_permutation;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * TODO 待提交测试
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return ;

        int minIndex = nums.length - 1, min = nums[minIndex];
        for(int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                swap(nums, i, nums.length - 1);
                Arrays.sort(nums, i+1, nums.length);
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
        caseCheck(new Solution(), "[1,1,2,5]","[2,5,1,1]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr);
        solution.nextPermutation(nums);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expectedStr), nums);
    }
}
