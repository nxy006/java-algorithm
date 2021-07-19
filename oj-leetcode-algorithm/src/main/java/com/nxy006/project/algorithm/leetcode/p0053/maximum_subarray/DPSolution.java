package com.nxy006.project.algorithm.leetcode.p0053.maximum_subarray;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划解法
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   38.7 MB , beats  78.65 % of java submissions.
 * 07/19/2021 23:18
 */
public class DPSolution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], ans = sum;
        for(int j = 1; j < nums.length; j++) {
            sum = sum < 0 ? nums[j]:(sum+nums[j]);
            ans = Integer.max(ans, sum);
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 6,"[-2,1,-3,4,-1,2,1,-5,4]");
        caseCheck(new DPSolution(), 1,"[1]");
        caseCheck(new DPSolution(), 23,"[5,4,-1,7,8]");
        // 自定义用例
        caseCheck(new DPSolution(), -1,"[-2,-2,-5,-6,-1,-8]");
        caseCheck(new DPSolution(), 50,"[1,1,1,1,1,-100,50]");
        caseCheck(new DPSolution(), 105,"[-8,100,-1,-1,-1,-1,-1,10,-500,100]");
    }

    private static void caseCheck(DPSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.maxSubArray(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
