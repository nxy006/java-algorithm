package com.nxy006.project.algorithm.leetcode.p0062.unique_paths;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(nm)，空间复杂度：O(nm)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   35.7 MB , beats  78.20 % of java submissions.
 * 07/20/2021 22:48
 */
public class DPSolution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = i == 0 || j == 0 ? 1 : dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(28, new DPSolution().uniquePaths(3, 7));
        CaseAssertUtils.assertEquals(3, new DPSolution().uniquePaths(3, 2));
        CaseAssertUtils.assertEquals(28, new DPSolution().uniquePaths(7, 3));
        CaseAssertUtils.assertEquals(6, new DPSolution().uniquePaths(3, 3));
    }
}
