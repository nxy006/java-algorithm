package com.nxy006.project.algorithm.leetcode.p0054.spiral_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, top = 0, left = 0, bottom = matrix.length-1, right = matrix[0].length-1, walk = 0;
        while(top <= bottom && left <= right) {
            if (i < top || i > bottom || j < left || j > right) {       // 越界说明已走到当前方向的尽头：恢复位置，更新界限，并重新分配方向
                switch (walk) {
                    case 0: top++; j--; break;
                    case 1: right--; i--; break;
                    case 2: bottom--; j++; break;
                    case 3: left++; i++; break;
                }
                walk = (walk + 1) % 4;                                  // 方向说明：0 向右，1 向下，2 向左，3 向右
            } else {
                ans.add(matrix[i][j]);
            }

            switch (walk) {                                             // 根据给定的方向前进
                case 0: j++; break;
                case 1: i++; break;
                case 2: j--; break;
                case 3: i--; break;
            }
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,3,6,9,8,7,4,5]", "[[1,2,3],[4,5,6],[7,8,9]]");
        caseCheck(new Solution(), "[1,2,3,4,8,12,11,10,9,5,6,7]", "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String matrixStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntegerList(expectedStr), solution.spiralOrder(StructConvertUtils.convertToIntMatrix(matrixStr)));
    }
}
