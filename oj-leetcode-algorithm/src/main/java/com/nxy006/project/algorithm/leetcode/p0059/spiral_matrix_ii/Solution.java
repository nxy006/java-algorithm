package com.nxy006.project.algorithm.leetcode.p0059.spiral_matrix_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0, j = 0, num = 1, top = 0, left = 0, bottom = n-1, right = n-1, walk = 0;
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
                ans[i][j] = num++;
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
        caseCheck(new Solution(), "[[1,2,3],[8,9,4],[7,6,5]]", 3);
        caseCheck(new Solution(), "[[1]]", 1);
    }

    private static void caseCheck(Solution solution, String expectedStr, int n) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expectedStr), solution.generateMatrix(n));
    }
}
