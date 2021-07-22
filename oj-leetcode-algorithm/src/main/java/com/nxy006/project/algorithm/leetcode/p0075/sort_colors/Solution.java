package com.nxy006.project.algorithm.leetcode.p0075.sort_colors;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int num : nums) {
            switch (num) {
                case 0: red++;  break;
                case 1: white++;break;
                default:blue++; break;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = red-- > 0 ? 0 : white-- > 0 ? 1 : 2;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[0,0,1,1,2,2]", "[2,0,2,1,1,0]");
        caseCheck(new Solution(), "[0,1,2]", "[2,0,1]");
        caseCheck(new Solution(), "[0]", "[0]");
        caseCheck(new Solution(), "[1]", "[1]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr);
        solution.sortColors(nums);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expectedStr), nums);
    }
}
