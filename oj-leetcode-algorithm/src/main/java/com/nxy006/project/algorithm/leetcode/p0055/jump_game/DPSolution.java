package com.nxy006.project.algorithm.leetcode.p0055.jump_game;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划解法（非最优解法）
 *
 * Runtime  78 ms   , beats 28.73 % of java submissions.
 * Memory   39.6 MB , beats 79.11 % of java submissions.
 * 07/19/2021 23:23
 */
public class DPSolution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return nums.length == 1;

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if (!dp[i]) continue;
            for(int j = 1; j <= nums[i]; j++) {
                if (i+j == nums.length-1) {
                    return true;
                }
                dp[i+j] = true;
            }
        }
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), true,"[2,3,1,1,4]");
        caseCheck(new DPSolution(), false,"[3,2,1,0,4]");
        // 自定义用例
        caseCheck(new DPSolution(), false,"[1,1,1,0,1,1]");
        caseCheck(new DPSolution(), true,"[10,9,8,7,6,5,4,3,2,1,0]");
        caseCheck(new DPSolution(), false,"[0,1,1,0,1,1]");
    }

    private static void caseCheck(DPSolution solution, boolean expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.canJump(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
