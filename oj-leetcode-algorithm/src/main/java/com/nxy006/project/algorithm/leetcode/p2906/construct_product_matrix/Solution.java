package com.nxy006.project.algorithm.leetcode.p2906.construct_product_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 数学算法
 * 时间复杂度：O(nm)，空间复杂度：O(1)
 *
 * Runtime  11 ms    , beats  89.85 % of java submissions.
 * Memory   71.98 MB , beats  56.87 % of java submissions.
 * 17/10/2023 23:16
 */
public class Solution {
    public static int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];

        int left = 1, right = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = left % MOD;
                left = (left * (grid[i][j] % MOD)) % MOD;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                res[i][j] = (res[i][j] * right) % MOD;
                right = (right * (grid[i][j] % MOD)) % MOD;
            }
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[24,12],[8,6]]", "[[1,2],[3,4]]");
        caseCheck(new Solution(), "[[2],[0],[0]]", "[[12345],[2],[1]]");
    }

    private static void caseCheck(Solution solution, String expectedNestArrayStr, String nestedArrayStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntMatrix(expectedNestArrayStr),
                solution.constructProductMatrix(StructConvertUtils.convertToIntMatrix(nestedArrayStr)));
    }
}
