package com.nxy006.project.algorithm.leetcode.p1275.find_winner_on_a_tic_tac_toe_game;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  12 ms   , beats  5.35 % of java submissions.
 * Memory   39.4 MB , beats --.-- % of java submissions.
 * 09/20/2021 22:56
 */
public class MapSolution {
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) return "Pending";

        Map<String, Integer> aMap = new HashMap<>(), bMap = new HashMap<>();
        boolean isA = true;
        for(int[] move : moves) {
            int x = move[0], y = move[1];
            Map<String, Integer> map = isA ? aMap : bMap;

            if (isWin(map, "x" + x) || isWin(map, "y" + y) || isWin(map, "a" + (y-x)) || isWin(map, "b" + (y+x))) {
                return isA ? "A" : "B";
            }
            isA = !isA;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean isWin(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        return map.get(key) == 3;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new MapSolution(), "A", "[[0,0],[2,0],[1,1],[2,1],[2,2]]");
        caseCheck(new MapSolution(), "B", "[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]");
        caseCheck(new MapSolution(), "Draw", "[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]");
        caseCheck(new MapSolution(), "Pending", "[[0,0],[1,1]]");
    }

    private static void caseCheck(MapSolution solution, String expected, String movesString) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.tictactoe(StructConvertUtils.convertToIntMatrix(movesString)));
    }
}
