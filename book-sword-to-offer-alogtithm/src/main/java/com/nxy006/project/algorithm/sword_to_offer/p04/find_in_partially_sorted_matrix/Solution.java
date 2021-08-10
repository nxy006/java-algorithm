package com.nxy006.project.algorithm.sword_to_offer.p04.find_in_partially_sorted_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 *       照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 *       整数，判断数组中是否含有该整数。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/04_FindInPartiallySortedMatrix
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：44.2 MB, 在所有 Java 提交中击败了  48.99 % 的用户
 * 2021/08/10 22:44
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length, i = n-1, j = 0;
        while(true) {
            if (i < 0 || i >= n || j < 0 || j >= m) {
                break;
            }

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // Leetcode-CN 题目示例
        caseCheck(new Solution(), true, "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", 5);
        // 书籍用例（省略用例7. 鲁棒性测试，输入空指针）
        caseCheck(new Solution(), true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 7);       // 1. 要查找的数在数组中
        caseCheck(new Solution(), false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 5);      // 2. 要查找的数不在数组中
        caseCheck(new Solution(), true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 1);       // 3. 要查找的数是数组中最小的数字
        caseCheck(new Solution(), true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 15);      // 4. 要查找的数在数组中
        caseCheck(new Solution(), false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 0);      // 5. 要查找的数比数组中最小的数字还小
        caseCheck(new Solution(), false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 16);     // 6. 要查找的数比数组中最大的数字还大
    }

    private static void caseCheck(Solution solution, boolean expected, String matrixStr, int target) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.findNumberIn2DArray(StructConvertUtils.convertToIntMatrix(matrixStr), target));
    }
}
