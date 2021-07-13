package com.nxy006.project.algorithm.leetcode.p0036.valid_sudoku;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * Map 解法
 * 时间复杂度：O(1)，空间复杂度：O(1)，一轮遍历只需要固定遍历 81 个位置，因而为常数级
 *
 * Runtime  15 ms , beats 17.29 % of java submissions.
 * Memory   40 MB , beats 22.98 % of java submissions.
 * 07/13/2021 22:58
 */
public class MapSolution {
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
        caseCheck(new MapSolution(), true, "" +
                "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        caseCheck(new MapSolution(), false, "" +
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

    private static void caseCheck(MapSolution solution, boolean expected, String matrixStr) {
        CaseAssertUtils.assertEquals(expected, solution.isValidSudoku(StructConvertUtils.convertToCharMatrix(matrixStr)));
    }
}
