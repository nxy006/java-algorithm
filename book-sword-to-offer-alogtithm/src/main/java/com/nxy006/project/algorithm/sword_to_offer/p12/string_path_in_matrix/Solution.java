package com.nxy006.project.algorithm.sword_to_offer.p12.string_path_in_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 *       上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 *       母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *       A B T G
 *       C F C S
 *       J D E H
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/12_StringPathInMatrix
 *
 * TODO 未提交测试
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (process(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int[][] walks = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean process(char[][] board, String word, int x, int y, int i) {
        if (i == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word.charAt(i)) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = '*';
        for(int[] walk : walks) {
            int nextX = x + walk[0], nextY = y + walk[1];
            if (process(board, word, nextX, nextY, i+1)) {
                return true;
            }
        }
        board[x][y] = temp;
        return false;
    }

    // TODO 临时借用 LeetCode 79 用例
    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), true, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "ABCCED");
        caseCheck(new Solution(), true, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "SEE");
        caseCheck(new Solution(), false, "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]", "ABCB");
        // 自定义用例
        caseCheck(new Solution(), true, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAA");
        caseCheck(new Solution(), false, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAAA");
        caseCheck(new Solution(), false, "[[\"A\",\"A\",\"A\",\"A\"],[\"A\",\"A\",\"A\",\"A\"]]", "AAAAAAAB");
        caseCheck(new Solution(), false, "[[\"A\",\"A\",\"B\",\"C\"],[\"A\",\"A\",\"B\",\"C\"]]", "AAAC");
    }

    private static void caseCheck(Solution solution, boolean expected, String boardStr, String word) {
        CaseAssertUtils.assertEquals(expected, solution.exist(StructConvertUtils.convertToCharMatrix(boardStr), word));
    }
}
