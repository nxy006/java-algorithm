package com.nxy006.project.algorithm.leetcode.p0121.best_time_to_buy_and_sell_stock;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  2 ms    , beats  87.02 % of java submissions.
 * Memory   77.2 MB , beats  69.37 % of java submissions.
 * 03/05/2022 01:23
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0], res = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Integer.min(min, prices[i]);
            res = Integer.max(res, prices[i]-min);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 5, "[7,1,5,3,6,4]");
        caseCheck(new Solution(), 0, "[7,6,4,3,1]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.maxProfit(StructConvertUtils.convertToIntArray(treeStr)));
    }
}
