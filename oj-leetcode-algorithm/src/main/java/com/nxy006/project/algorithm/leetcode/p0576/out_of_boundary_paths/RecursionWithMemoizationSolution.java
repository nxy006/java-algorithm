package com.nxy006.project.algorithm.leetcode.p0576.out_of_boundary_paths;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * 记忆化递归搜索
 *
 * Runtime  4 ms    , beats 76.48 % of java submissions.
 * Memory   38.2 MB , beats 42.37 % of java submissions.
 * 06/25/2021 12:58
 */
public class RecursionWithMemoizationSolution {
    private final int[][] walks = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private final int M = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] ans = new int[m][n][maxMove];
        for(int[][] arr : ans) {
            for(int[] subArr : arr) {
                Arrays.fill(subArr, -1);
            }
        }

        return move(m, n, maxMove, startRow, startColumn, 0, ans);
    }

    private int move(int m, int n, int maxMove, int x, int y, int step, int[][][] ans) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (step >= maxMove) return 0;
        if (ans[x][y][step] != -1) return ans[x][y][step];

        long cnt = 0;
        for(int[] walk : walks) {
            cnt += move(m, n, maxMove, x+walk[0], y+walk[1], step+1, ans) % M;
        }
        return ans[x][y][step] = (int) (cnt % M);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new RecursionWithMemoizationSolution(), 6, 2, 2, 2, 0, 0);
        caseCheck(new RecursionWithMemoizationSolution(), 12, 1, 3, 3, 0, 1);
        caseCheck(new RecursionWithMemoizationSolution(), 150, 1, 2, 50, 0, 0);
        caseCheck(new RecursionWithMemoizationSolution(), 914783380, 8, 50, 23, 5, 26);
    }

    private static void caseCheck(RecursionWithMemoizationSolution solution, int expected, int m, int n, int maxMove, int startRow, int startColumn) {
        CaseAssertUtils.assertEquals(expected, solution.findPaths(m, n, maxMove, startRow, startColumn));
    }
}
