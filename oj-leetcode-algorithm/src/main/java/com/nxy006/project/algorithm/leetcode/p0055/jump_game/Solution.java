package com.nxy006.project.algorithm.leetcode.p0055.jump_game;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
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
        caseCheck(new Solution(), true,"[2,3,1,1,4]");
        caseCheck(new Solution(), false,"[3,2,1,0,4]");
        // 自定义用例
        caseCheck(new Solution(), false,"[1,1,1,0,1,1]");
        caseCheck(new Solution(), true,"[10,9,8,7,6,5,4,3,2,1,0]");
        caseCheck(new Solution(), false,"[0,1,1,0,1,1]");
    }

    private static void caseCheck(Solution solution, boolean expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.canJump(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
