package com.nxy006.project.algorithm.leetcode.p0152.maximum_product_subarray;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划
 * 用 max、min 记录以每个值作为最后一个数子的子数组的最大、最小乘积即可
 *
 * Runtime 1 ms    , beats 92.76 % of java submissions.
 * Memory  38.6 MB , beats 94.18 % of java submissions.
 * 12/04/2021 00:30
 */
public class DPSolution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int newMax = Integer.max(nums[i], Integer.max(min * nums[i], max * nums[i]));
            int newMin = Integer.min(nums[i], Integer.min(min * nums[i], max * nums[i]));

            max = newMax;
            min = newMin;
            res = Integer.max(res, max);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 6, "[2,3,-2,4]");
        caseCheck(new DPSolution(), 0, "[-2,0,-1]");
        // 自定义用例
        caseCheck(new DPSolution(), 20, "[-2,0,-1,-2,-2,-5]");
        caseCheck(new DPSolution(), 1, "[1]");
        caseCheck(new DPSolution(), 1, "[1,1,1,1,1,-1]");
        caseCheck(new DPSolution(), 1, "[0,0,0,1]");
        caseCheck(new DPSolution(), 48000, "[5,2,8,-10,1,2,3,1,-10]");
        caseCheck(new DPSolution(), 80, "[5,2,8,-10,1,2,3,1,6]");
    }

    private static void caseCheck(DPSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.maxProduct(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
