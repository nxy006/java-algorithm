package com.nxy006.project.algorithm.leetcode.p1217.minimum_cost_to_move_chips_to_the_same_position;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 常规解法
 * 题意相当于位于奇数位、偶数位的硬币各自可以无成本移动，改变奇数、偶数位置才有成本，因而将奇数、偶数位数量较少的一部分转换即为答案。
 *
 * Runtime 7 ms    , beats 14.52 % of java submissions.
 * Memory  36.3 MB , beats 89.87 % of java submissions.
 * 12/07/2021 00:04
 */
public class Solution {
    public int minCostToMoveChips(int[] chips) {
        int singleNum = 0, doubleNum = 0;
        for(int chip : chips) {
            if (chip % 2 == 1) singleNum++;
        }
        doubleNum = chips.length - singleNum;

        return doubleNum <= singleNum ? doubleNum : singleNum;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 1,"[1,2,3]");
        caseCheck(new Solution(), 2,"[2,2,2,3,3]");
        caseCheck(new Solution(), 1,"[1,1000000000]");
    }

    private static void caseCheck(Solution solution, int expected, String chipsStr) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.minCostToMoveChips(StructConvertUtils.convertToIntArray(chipsStr))
        );
    }
}
