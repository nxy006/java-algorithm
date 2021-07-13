package com.nxy006.project.algorithm.leetcode.p0036.valid_sudoku;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * TODO 待提交测试
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] < '0' || board[i][j] > '9') continue;

                int num = board[i][j] - '0';
                Set<Integer> rowSet = map.getOrDefault("row_" + i, new HashSet<>()),
                        colSet = map.getOrDefault("col_" + j, new HashSet<>()),
                        ceilSet = map.getOrDefault("ceil_" + (i/3) + "_" + (j/3), new HashSet<>());

                if (rowSet.contains(num) || colSet.contains(num) || ceilSet.contains(num)) {
                    return false;
                }
                rowSet.add(num);
                map.put("row_" + i, rowSet);
                colSet.add(num);
                map.put("col_" + j, colSet);
                ceilSet.add(num);
                map.put("ceil_" + (i/3) + "_" + (j/3), ceilSet);
            }
        }
        return true;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), true, "" +
                "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        caseCheck(new Solution(), false, "" +
                "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
    }

    private static void caseCheck(Solution solution, boolean expected, String matrixStr) {
        CaseAssertUtils.assertEquals(expected, solution.isValidSudoku(StructConvertUtils.convertToCharMatrix(matrixStr)));
    }
}
