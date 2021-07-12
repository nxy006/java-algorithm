package com.nxy006.project.algorithm.leetcode.p0026.remove_duplicates_from_sorted_array;

import com.nxy006.project.algorithm.leetcode.p0004.median_of_two_sorted_arrays.TwoPointSolution;
import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            nums[l++] = nums[i];
        }
        return l;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2]","[1,1,2]");
        caseCheck(new Solution(), "[0,1,2,3,4]","[0,0,1,1,1,2,2,3,3,4]");
        // 自定义用例
        caseCheck(new Solution(), "[1]","[1,1,1,1,1]");
        caseCheck(new Solution(), "[]","[]");
    }

    private static void caseCheck(Solution solution, String expectedNumsStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr), expectedNums = StructConvertUtils.convertToIntArray(expectedNumsStr);
        solution.removeDuplicates(nums);
        CaseAssertUtils.assertEqualsWithLength(expectedNums, nums, expectedNums.length);
    }
}
