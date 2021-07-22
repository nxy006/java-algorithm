package com.nxy006.project.algorithm.leetcode.p0070.climbing_stairs;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class RecursionSolution {
    int[] arr = new int[46];

    public int climbStairs(int n) {
        if (n <= 1) return 1;
        if (arr[n] != 0) return arr[n];

        return arr[n] = climbStairs(n-1) + climbStairs(n-2);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), 2, 2);
        caseCheck(new RecursionSolution(), 3, 3);
    }

    private static void caseCheck(RecursionSolution solution, int expected, int n) {
        CaseAssertUtils.assertEquals(expected, solution.climbStairs(n));
    }
}
