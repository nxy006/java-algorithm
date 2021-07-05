package com.nxy006.project.algorithm.leetcode.p0576.out_of_boundary_paths;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 动态规划解法
 *
 * Runtime  10 ms   , beats 38.14 % of java submissions.
 * Memory   38.3 MB , beats 33.05 % of java submissions.
 * 06/25/2021 14:09
 */
public class DPSolution {
    private final int[][] walks = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int M = 1000000007, count = 0;

        dp[startRow][startColumn] = 1;
        for(int t = 0; t < maxMove; t++) {
            int[][] temp = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (i == m-1) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    if (j == n-1) count = (count + dp[i][j]) % M;

                    int ans = 0;
                    for(int[] walk : walks) {
                        int x = i + walk[0], y = j + walk[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;

                        ans = (ans + dp[x][y]) % M;
                    }
                    temp[i][j] = ans;
                }
            }
            dp = temp;
        }
        return count;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new DPSolution(), 6, 2, 2, 2, 0, 0);
        caseCheck(new DPSolution(), 12, 1, 3, 3, 0, 1);
        caseCheck(new DPSolution(), 150, 1, 2, 50, 0, 0);
        caseCheck(new DPSolution(), 914783380, 8, 50, 23, 5, 26);
    }

    private static void caseCheck(DPSolution solution, int expected, int m, int n, int maxMove, int startRow, int startColumn) {
        CaseAssertUtils.assertEquals(expected, solution.findPaths(m, n, maxMove, startRow, startColumn));
    }
}
