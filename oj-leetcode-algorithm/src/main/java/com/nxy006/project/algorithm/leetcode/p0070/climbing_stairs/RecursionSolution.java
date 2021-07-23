package com.nxy006.project.algorithm.leetcode.p0070.climbing_stairs;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 递归解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   35.7 MB , beats  55.65 % of java submissions.
 * 07/24/2021 00:03
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
