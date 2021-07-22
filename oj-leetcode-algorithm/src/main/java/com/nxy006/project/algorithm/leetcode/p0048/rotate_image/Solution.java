package com.nxy006.project.algorithm.leetcode.p0048.rotate_image;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 模拟解法：根据规则旋转即可
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.2 MB , beats  48.18 % of java submissions.
 * 07/22/2021 23:41
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int maxI = n / 2, maxJ = m / 2 + m % 2;
        for(int i = 0; i < maxI; i++) {
            for(int j = 0; j < maxJ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][m-1-j];
                matrix[n-1-i][m-1-j] = matrix[j][m-1-i];
                matrix[j][m-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[7,4,1],[8,5,2],[9,6,3]]", "[[1,2,3],[4,5,6],[7,8,9]]");
        caseCheck(new Solution(), "[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]", "[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        caseCheck(new Solution(), "[[1]]", "[[1]]");
        caseCheck(new Solution(), "[[3,1],[4,2]]", "[[1,2],[3,4]]");
    }

    private static void caseCheck(Solution solution, String expected, String matrixStr) {
        int[][] matrix = StructConvertUtils.convertToIntMatrix(matrixStr);
        solution.rotate(matrix);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expected), matrix);
    }
}
