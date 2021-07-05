package com.nxy006.project.algorithm.leetcode.p0778.swim_in_rising_water;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * BFS + PriorityQueue
 * 基于优先队列的宽度优先搜索
 *
 * Runtime  20 ms   , beats 25.05 % of java submissions.
 * Memory   39 MB   , beats 47.56 % of java submissions.
 * 06/21/2021 11:33
 */
public class BFSWithPriorityQueueSolution {
    private static final int[][] walks = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // 数据初始化
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        queue.offer(new Pair<>(new Pair<>(0, 0), 0));

        // 广度优先搜索
        while(!queue.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> pair = queue.poll();
            Pair<Integer, Integer> place = pair.getKey();

            // 结束判断
            if (place.getKey() == n-1 && place.getValue() == m-1) {
                return pair.getValue();
            }
            // 过滤不必要的数据
            if (pair.getValue() >= dp[place.getKey()][place.getValue()]) {
                continue;
            }
            dp[place.getKey()][place.getValue()] = pair.getValue();

            // 前进
            for(int[] walk : walks) {
                int x = place.getKey() + walk[0], y = place.getValue() + walk[1];
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                // 在已有预计最大时间和本次移动需要的最大时间（两个位置间的较大高度）中取较大值
                int time = Integer.max(dp[place.getKey()][place.getValue()], Integer.max(grid[place.getKey()][place.getValue()], grid[x][y]));
                if (time < dp[x][y]) {
                    queue.offer(new Pair<>(new Pair<>(x, y), time));
                }
            }
        }
        return dp[n-1][m-1];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new BFSWithPriorityQueueSolution(), 3, "[[0,2],[1,3]]");
        caseCheck(new BFSWithPriorityQueueSolution(), 16, "[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        caseCheck(new BFSWithPriorityQueueSolution(), 3, "[[3,2],[1,0]]");
        caseCheck(new BFSWithPriorityQueueSolution(), 11, "[[11,15,3,2],[6,4,0,13],[5,8,9,10],[1,14,12,7]]");
    }

    private static void caseCheck(BFSWithPriorityQueueSolution solution, int expected, String arrStr) {
        CaseAssertUtils.assertEquals(expected, solution.swimInWater(StructConvertUtils.convertToIntMatrix(arrStr)));
    }
}
