package com.nxy006.project.algorithm.leetcode.p0778.swim_in_rising_water;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Dijkstra 算法（最小生成树）
 * 每个边的权重（花费时间），视为其两端高度的较大值
 *
 * Runtime  33 ms   , beats 15.01 % of java submissions.
 * Memory   39.7 MB , beats 20.83 % of java submissions.
 * 06/21/2021 12:48
 */
public class DijkstraSolution {
    private static final int[][] walks = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        queue.offer(new Pair<>(new Pair<>(0, 0), 0));

        int time = 0;
        while(!queue.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> pair = queue.poll();
            Pair<Integer, Integer> place = pair.getKey();

            if (place.getKey() == n-1 && place.getValue() == m-1) {
                return Integer.max(time, pair.getValue());
            }
            if (set.contains(place)) {
                continue;
            }

            set.add(place);
            time = Integer.max(time, pair.getValue());

            // Walk
            for(int[] walk : walks) {
                int x = place.getKey() + walk[0], y = place.getValue() + walk[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    queue.offer(new Pair<>(new Pair<>(x, y), Integer.max(grid[place.getKey()][place.getValue()], grid[x][y])));
                }
            }
        }
        return time;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new DijkstraSolution(), 3, "[[0,2],[1,3]]");
        caseCheck(new DijkstraSolution(), 16, "[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        caseCheck(new DijkstraSolution(), 3, "[[3,2],[1,0]]");
        caseCheck(new DijkstraSolution(), 11, "[[11,15,3,2],[6,4,0,13],[5,8,9,10],[1,14,12,7]]");
    }

    private static void caseCheck(DijkstraSolution solution, int expected, String arrStr) {
        CaseAssertUtils.assertEquals(expected, solution.swimInWater(StructConvertUtils.convertToIntMatrix(arrStr)));
    }
}
