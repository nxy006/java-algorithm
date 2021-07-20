package com.nxy006.project.algorithm.leetcode.p0063.unique_paths_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class DPSolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = i == 0 || j == 0 ? 1 : obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 2, "[[0,0,0],[0,1,0],[0,0,0]]");
        caseCheck(new DPSolution(), 1, "[[0,1],[0,0]]");
        // 自定义用例
        caseCheck(new DPSolution(), 0, "[[0,0,0],[0,1,0],[0,0,1]]");
        caseCheck(new DPSolution(), 0, "[[0,0,0],[0,1,1],[0,1,0]]");
        caseCheck(new DPSolution(), 1, "[[0,0,0],[0,1,0],[0,1,0]]");
    }

    private static void caseCheck(DPSolution solution, int expected, String matrixStr) {
        CaseAssertUtils.assertEquals(expected, solution.uniquePathsWithObstacles(StructConvertUtils.convertToIntMatrix(matrixStr)));
    }
}
