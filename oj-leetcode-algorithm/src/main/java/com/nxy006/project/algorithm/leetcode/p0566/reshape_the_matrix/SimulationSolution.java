package com.nxy006.project.algorithm.leetcode.p0566.reshape_the_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 模拟解法（按行遍历二维数组）
 * 时间复杂度：O(rc)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.8 MB , beats  68.66 % of java submissions.
 * 07/05/2021 23:03
 */
public class SimulationSolution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length, m = mat[0].length;
        if (n * m != r * c || n == r && m == c) return mat;

        int[][] arr = new int[r][c];
        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[k/c][k%c] = mat[i][j];
                k++;
            }
        }
        return arr;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new SimulationSolution(), "[[1,2,3,4]]", "[[1,2],[3,4]]", 1, 4);
        caseCheck(new SimulationSolution(), "[[1,2],[3,4]]", "[[1,2],[3,4]]", 2, 4);
    }

    private static void caseCheck(SimulationSolution solution, String expected, String arrStr, int r, int c) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expected),
                solution.matrixReshape(StructConvertUtils.convertToIntMatrix(arrStr), r, c));
    }
}
