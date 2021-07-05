package com.nxy006.project.algorithm.leetcode.p0778.swim_in_rising_water;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 二分搜索解法
 *
 * Runtime  3 ms    , beats 95.59 % of java submissions.
 * Memory   39.3 MB , beats 35.74 % of java submissions.
 * 06/21/2021 11:33
 */
public class BinarySearchSolution {
    private final int[][] walks = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int n = 0, m = 0;

    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        int l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (canSwimWaterWithTime(grid, 0, 0, mid, new boolean[n][m])) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    private boolean canSwimWaterWithTime(int[][] grid, int x, int y, int t, boolean[][] visit) {
        if (x == n-1 && y == m-1) return true;
        if (grid[0][0] > t) return false;

        visit[x][y] = true;
        for(int[] walk : walks) {
            int nextX = x + walk[0], nextY = y + walk[1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m &&
                    grid[nextX][nextY] <= t && !visit[nextX][nextY] && canSwimWaterWithTime(grid, nextX, nextY, t, visit)) {
                return true;
            }
        }
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new BinarySearchSolution(), 3, "[[0,2],[1,3]]");
        caseCheck(new BinarySearchSolution(), 16, "[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]");
        caseCheck(new BinarySearchSolution(), 3, "[[3,2],[1,0]]");
        caseCheck(new BinarySearchSolution(), 11, "[[11,15,3,2],[6,4,0,13],[5,8,9,10],[1,14,12,7]]");
    }

    private static void caseCheck(BinarySearchSolution solution, int expected, String arrStr) {
        CaseAssertUtils.assertEquals(expected, solution.swimInWater(StructConvertUtils.convertToIntMatrix(arrStr)));
    }
}
