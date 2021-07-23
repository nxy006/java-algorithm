package com.nxy006.project.algorithm.leetcode.p0079.word_search;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class RecursionSolution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word, 1, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] walks = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private boolean search(char[][] board, String word, int i, int x, int y) {
        if (i >= word.length()) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '0';
        for(int[] walk : walks) {
            int nextX = x + walk[0], nextY = y + walk[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[nextX].length && board[nextX][nextY] == word.charAt(i)) {
                if (search(board, word, i+1, nextX, nextY)) {
                    return true;
                }
            }
        }
        board[x][y] = temp;
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), true, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "ABCCED");
        caseCheck(new RecursionSolution(), true, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "SEE");
        caseCheck(new RecursionSolution(), false, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "ABCB");
        // 自定义用例
        caseCheck(new RecursionSolution(), true, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAA");
        caseCheck(new RecursionSolution(), false, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAAA");
        caseCheck(new RecursionSolution(), false, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAB");
        caseCheck(new RecursionSolution(), false, "[[\"A\",\"A\",\"B\",\"C\"],[\"A\",\"A\",\"B\",\"C\"]]", "AAAC");
    }

    private static void caseCheck(RecursionSolution solution, boolean expected, String boardStr, String word) {
        CaseAssertUtils.assertEquals(expected, solution.exist(StructConvertUtils.convertToCharMatrix(boardStr), word));
    }
}
