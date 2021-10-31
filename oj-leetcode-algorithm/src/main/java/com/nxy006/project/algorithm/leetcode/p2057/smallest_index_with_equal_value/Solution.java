package com.nxy006.project.algorithm.leetcode.p2057.smallest_index_with_equal_value;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

public class Solution {
    public int smallestEqual(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 0, "[0,1,2]");
        caseCheck(new Solution(), 2, "[4,3,2,1]");
        caseCheck(new Solution(), -1, "[1,2,3,4,5,6,7,8,9,0]");
        caseCheck(new Solution(), 1, "[2,1,3,5,2]");
    }

    private static void caseCheck(Solution solution, int expected, String arrStr) {
        CaseAssertUtils.assertEquals(expected, solution.smallestEqual(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
