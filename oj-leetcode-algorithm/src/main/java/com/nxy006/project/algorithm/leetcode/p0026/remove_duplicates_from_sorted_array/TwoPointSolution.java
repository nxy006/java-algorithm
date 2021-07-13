package com.nxy006.project.algorithm.leetcode.p0026.remove_duplicates_from_sorted_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 48.40 % of java submissions.
 * Memory   40.8 MB , beats 47.15 % of java submissions.
 * 07/13/2021 22:34
 */
public class TwoPointSolution {
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
        caseCheck(new TwoPointSolution(), "[1,2]","[1,1,2]");
        caseCheck(new TwoPointSolution(), "[0,1,2,3,4]","[0,0,1,1,1,2,2,3,3,4]");
        // 自定义用例
        caseCheck(new TwoPointSolution(), "[1]","[1,1,1,1,1]");
        caseCheck(new TwoPointSolution(), "[]","[]");
    }

    private static void caseCheck(TwoPointSolution solution, String expectedNumsStr, String numsStr) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr), expectedNums = StructConvertUtils.convertToIntArray(expectedNumsStr);
        solution.removeDuplicates(nums);
        CaseAssertUtils.assertEqualsWithLength(expectedNums, nums, expectedNums.length);
    }
}
