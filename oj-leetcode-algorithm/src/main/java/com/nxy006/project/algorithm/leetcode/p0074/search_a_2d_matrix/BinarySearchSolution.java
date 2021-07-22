package com.nxy006.project.algorithm.leetcode.p0074.search_a_2d_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 二分解法
 * 时间复杂度：O(log_n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   38.3 MB , beats  69.56 % of java submissions.
 * 07/22/2021 23:54
 */
public class BinarySearchSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, l = 0, r = n*m-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (matrix[mid/m][mid%m] == target) {
                return true;
            } else if (matrix[mid/m][mid%m] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), true, "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", 3);
        caseCheck(new BinarySearchSolution(), false, "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]", 13);
        // 自定义用例
        caseCheck(new BinarySearchSolution(), false, "[[2,3,5,7],[10,11,16,20],[23,30,34,60]]", 1);
        caseCheck(new BinarySearchSolution(), false, "[[2,3,5,7],[10,11,16,20],[23,30,34,60]]", 63);
        caseCheck(new BinarySearchSolution(), true, "[[2,3,5,7],[10,11,16,20],[23,30,34,60]]", 11);
        caseCheck(new BinarySearchSolution(), true, "[[2,3,5,7],[10,11,16,20],[23,30,34,60]]", 16);
    }

    private static void caseCheck(BinarySearchSolution solution, boolean expected, String matrixStr, int target) {
        CaseAssertUtils.assertEquals(expected, solution.searchMatrix(StructConvertUtils.convertToIntMatrix(matrixStr), target));
    }
}
