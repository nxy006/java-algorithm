package com.nxy006.project.algorithm.leetcode.p0080.remove_duplicates_from_sorted_array_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 双指针扫描
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   39 MB , beats  68.88 % of java submissions.
 * 07/23/2021 23:45
 */
public class TwoPointSolution {
    public int removeDuplicates(int[] nums) {
        int i = 1, cnt = 1;
        for(int j = 1; j < nums.length; j++) {
            if (nums[j-1] != nums[j]) {
                cnt = 0;
            } else if (cnt >= 2) {
                continue;
            }

            nums[i++] = nums[j];
            cnt++;
        }
        return i;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointSolution(), "[1,1,2,2,3]","[1,1,1,2,2,3]");
        caseCheck(new TwoPointSolution(), "[0,0,1,1,2,3,3]","[0,0,1,1,1,1,2,3,3]");
    }

    private static void caseCheck(TwoPointSolution solution, String expectedNumsStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr), expectedNums = StructConvertUtils.convertToIntArray(expectedNumsStr);
        CaseAssertUtils.assertEquals(expectedNums.length, solution.removeDuplicates(nums));
        CaseAssertUtils.assertEqualsWithLength(expectedNums, nums, expectedNums.length);
    }
}
