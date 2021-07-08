package com.nxy006.project.algorithm.leetcode.p0718.maximum_length_of_repeated_subarray;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(nm)，空间复杂度：O(nm)
 *
 * Runtime  49 ms , beats 58.03 % of java submissions.
 * Memory   48 MB , beats 41.83 % of java submissions.
 * 07/08/2021 23:57
 */
public class DPSolution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int res = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = (i == 0 || j == 0 ? 0 : dp[i-1][j-1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Integer.max(res, dp[i][j]);
            }
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new DPSolution(), 3, "[1,2,3,2,1]", "[3,2,1,4,7]");
        caseCheck(new DPSolution(), 5, "[0,0,0,0,0]", "[0,0,0,0,0]");
    }

    private static void caseCheck(DPSolution solution, int expected, String nums1Str, String nums2Str) {
        CaseAssertUtils.assertEquals(expected,
                solution.findLength(StructConvertUtils.convertToIntArray(nums1Str), StructConvertUtils.convertToIntArray(nums2Str)));
    }
}
