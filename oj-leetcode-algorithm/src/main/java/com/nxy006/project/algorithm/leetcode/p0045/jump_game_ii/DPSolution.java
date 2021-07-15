package com.nxy006.project.algorithm.leetcode.p0045.jump_game_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 动态规划解法
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 *
 * Runtime  422 ms  , beats 5.01 % of java submissions.
 * Memory   39.1 MB , beats 81.50 % of java submissions.
 * 07/08/2021 23:57
 */
public class DPSolution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = Integer.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 2, "[2,3,1,1,4]");
        caseCheck(new DPSolution(), 2, "[2,3,0,1,4]");
        // 自定义用例
        caseCheck(new DPSolution(), 1, "[100,0,0,0,0,0,0,1]");
        caseCheck(new DPSolution(), 0, "[1]");
        caseCheck(new DPSolution(), 2, "[5,5,5,100,0,0,0,0,0,0,0,1]");
        caseCheck(new DPSolution(), 2, "[5,1,1,100,1,1,1,1,1,1,1,1]");
    }

    private static void caseCheck(DPSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.jump(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
