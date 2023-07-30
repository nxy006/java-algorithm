package com.nxy006.project.algorithm.sword_to_offer.p04.find_in_partially_sorted_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题4：二维数组中的查找
 * <p>
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/tree/master/04_FindInPartiallySortedMatrix">gitHub</a>
 * <p/>
 *
 * <p>
 * LeetCode-CN 解答：<br/>
 * - Link：<a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">leetcode-cn</a><br/>
 * - 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户<br/>
 * - 内存消耗：44.2 MB, 在所有 Java 提交中击败了  48.99 % 的用户<br/>
 * - 2021/08/10 22:44
 * <p/>
 */
public class Solution extends SolutionTemplate {
    @Override
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

    public static void main(String[] args) {
        SolutionTemplate.processCaseTest(new Solution());
    }
}
