package com.nxy006.project.algorithm.leetcode.p0198.house_robber;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   36.4 MB , beats  74.44 % of java submissions.
 * 12/01/2021 23:18
 */
public class DPSolution {
    public int rob(int[] nums) {
        int robAmount = 0, notRobAmount = 0;
        for(int num : nums) {
            int prevAmount = notRobAmount;
            notRobAmount = Integer.max(notRobAmount, robAmount);
            robAmount = prevAmount + num;
        }
        return Integer.max(notRobAmount, robAmount);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 4, "[1,2,3,1]");
        caseCheck(new DPSolution(), 12, "[2,7,9,3,1]");
        // 自定义用例
        caseCheck(new DPSolution(), 1, "[1]");
        caseCheck(new DPSolution(), 3, "[1,1,1,1,1]");
        caseCheck(new DPSolution(), 114, "[1,2,5,4,3,1,100,1,5,4]");
    }

    private static void caseCheck(DPSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.rob(StructConvertUtils.convertToIntArray(numsStr)));
    }
}