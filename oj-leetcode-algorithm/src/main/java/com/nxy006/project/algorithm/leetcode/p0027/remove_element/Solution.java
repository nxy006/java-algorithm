package com.nxy006.project.algorithm.leetcode.p0027.remove_element;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[2,2]","[3,2,2,3]", 3);
        caseCheck(new Solution(), "[0,1,4,0,3]","[0,1,2,2,3,0,4,2]", 2);
        // 自定义用例
        caseCheck(new Solution(), "[]","[2,2,2,2]", 2);
        caseCheck(new Solution(), "[0]","[0]", 7);
        caseCheck(new Solution(), "[]","[]", 5);
    }

    private static void caseCheck(Solution solution, String expectedNumsStr, String numsStr, int val) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr), expectedNums = StructConvertUtils.convertToIntArray(expectedNumsStr);
        CaseAssertUtils.assertEquals(expectedNums.length, solution.removeElement(nums, val));
        CaseAssertUtils.assertEqualsIgnoreOrderWithLength(expectedNums, nums, expectedNums.length);
    }
}
