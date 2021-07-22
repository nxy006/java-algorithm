package com.nxy006.project.algorithm.leetcode.p0073.set_matrix_zeroes;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * TODO 待提交测试
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false, colZero = false;
        // Init Check
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }

        // Sign 标记
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 填充 0 值
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = (matrix[i][0] == 0 || matrix[0][j] == 0) ? 0 : matrix[i][j];
            }
        }

        // 还原首行首列
        if (rowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (colZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,0,1],[0,0,0],[1,0,1]]", "[[1,1,1],[1,0,1],[1,1,1]]");
        caseCheck(new Solution(), "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]", "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        // 官方用例
        caseCheck(new Solution(), "[[1,2,3],[4,5,6],[7,8,9]]", "[[1,2,3],[4,5,6],[7,8,9]]");
        caseCheck(new Solution(), "[[0,0,0],[0,0,0],[0,0,0]]", "[[0,0,0],[0,0,0],[0,0,0]]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String matrixStr) {
        int[][] matrix = StructConvertUtils.convertToIntMatrix(matrixStr);
        solution.setZeroes(matrix);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expectedStr), matrix);
    }
}
