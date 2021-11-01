package com.nxy006.project.algorithm.leetcode.P0130.surrounded_regions;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 深度优先遍历
 * 反向思考，从边缘开始找 O 符号并扩大范围，并临时标记为 R 符号，全部检查后将 R 替换为 O，其他均替换为 X 即可
 * 时间复杂度：O(nm)，空间复杂度：O(1)
 *
 * Runtime 2 ms    , beats 71.56 % of java submissions.
 * Memory  41.2 MB , beats 69.17 % of java submissions.
 * 11/01/2021 23:39
 */
public class DfsSolution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length-1 || j == 0 || j == board[i].length-1) && board[i][j] == 'O') {
                    expand(board, i, j);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'R') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static final int[][] walks = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void expand(char[][] board, int i, int j) {
        if (board[i][j] != 'O') return ;

        board[i][j] = 'R';
        for(int[] walk : walks) {
            int nextI = i + walk[0], nextJ = j + walk[1];
            if (nextI >= 0 &&  nextI < board.length && nextJ >= 0 && nextJ < board[nextI].length && board[nextI][nextJ] == 'O') {
                expand(board, nextI, nextJ);
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DfsSolution(),
                "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]",
                "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]");
        caseCheck(new DfsSolution(),
                "[[\"X\"]]",
                "[[\"X\"]]");
    }

    private static void caseCheck(DfsSolution solution, String boardExpected, String boardInputd) {
        char[][] board = StructConvertUtils.convertToCharMatrix(boardInputd);
        solution.solve(board);

        CaseAssertUtils.assertEquals(StructConvertUtils.convertToCharMatrix(boardExpected), board);
    }
}
