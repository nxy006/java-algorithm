package com.nxy006.project.algorithm.leetcode.p0037.sudoku_solver;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Map 解法
 * 时间复杂度：O(9^81)，空间复杂度：O(1)，本题算法时间复杂度很大程度取决于给定的输入数据，这里只给出渐进复杂度上界，即 81 个位置每个位置 9 种取值
 *
 * Runtime  36 ms   , beats 8.28 % of java submissions.
 * Memory   39.8 MB , beats 5.12 % of java submissions.
 * 07/13/2021 23:02
 */
public class RecursionSolution {
    public void solveSudoku(char[][] board) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            map.put("row_" + i, new HashSet<>());
            map.put("col_" + i, new HashSet<>());
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                map.put("ceil_" + i + "_" + j, new HashSet<>());
            }
        }

        int firstI = -1, firstJ = -1;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    if (firstI == -1) {
                        firstI = i;
                        firstJ = j;
                    }
                    continue;
                }

                int num = board[i][j] - '0';
                Set<Integer> rowSet = map.get("row_" + i), colSet = map.get("col_" + j), ceilSet = map.get("ceil_" + (i/3) + "_" + (j/3));
                rowSet.add(num);
                colSet.add(num);
                ceilSet.add(num);
            }
        }
        if (firstI != -1) {
            process(board, firstI, firstJ, map);
        }
    }

    private boolean process(char[][] board, int i, int j, Map<String, Set<Integer>> map) {
        if (board[i][j] != '.') return false;

        Set<Integer> rowSet = map.get("row_" + i), colSet = map.get("col_" + j), ceilSet = map.get("ceil_" + (i/3) + "_" + (j/3));
        for(int t = 1; t <= 9; t++) {
            if (rowSet.contains(t) || colSet.contains(t) || ceilSet.contains(t)) {
                continue;
            }

            board[i][j] = (char)('0' + t);
            rowSet.add(t);
            colSet.add(t);
            ceilSet.add(t);

            // 找到下个需要填充的位置，如果找不到或能够填充成功，则 return true，不恢复现场
            int[] next = nextPlace(board, i, j);
            if (next[0] == -1 || process(board, next[0], next[1], map)) {
                return true;
            }

            // 未找到合理的解，恢复现场重试
            board[i][j] = '.';
            rowSet.remove(t);
            colSet.remove(t);
            ceilSet.remove(t);
        }
        return false;
    }

    private int[] nextPlace(char[][] board, int i, int j) {
        for(j = j+1; j < board[i].length; j++) {
            if (board[i][j] == '.') {
                return new int[]{i, j};
            }
        }
        for(i = i+1; i < board.length; i++) {
            for(j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "" +
                        "[[\"5\",\"3\",\"4\",\"6\",\"7\",\"8\",\"9\",\"1\",\"2\"]" +
                        ",[\"6\",\"7\",\"2\",\"1\",\"9\",\"5\",\"3\",\"4\",\"8\"]" +
                        ",[\"1\",\"9\",\"8\",\"3\",\"4\",\"2\",\"5\",\"6\",\"7\"]" +
                        ",[\"8\",\"5\",\"9\",\"7\",\"6\",\"1\",\"4\",\"2\",\"3\"]" +
                        ",[\"4\",\"2\",\"6\",\"8\",\"5\",\"3\",\"7\",\"9\",\"1\"]" +
                        ",[\"7\",\"1\",\"3\",\"9\",\"2\",\"4\",\"8\",\"5\",\"6\"]" +
                        ",[\"9\",\"6\",\"1\",\"5\",\"3\",\"7\",\"2\",\"8\",\"4\"]" +
                        ",[\"2\",\"8\",\"7\",\"4\",\"1\",\"9\",\"6\",\"3\",\"5\"]" +
                        ",[\"3\",\"4\",\"5\",\"2\",\"8\",\"6\",\"1\",\"7\",\"9\"]]",
                "" +
                        "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]" +
                        ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]" +
                        ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]" +
                        ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]" +
                        ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]" +
                        ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]" +
                        ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]" +
                        ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]" +
                        ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
    }

    private static void caseCheck(RecursionSolution solution, String expectedStr, String matrixStr) {
        char[][] board = StructConvertUtils.convertToCharMatrix(matrixStr);
        solution.solveSudoku(board);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToCharMatrix(expectedStr), board);
    }
}
