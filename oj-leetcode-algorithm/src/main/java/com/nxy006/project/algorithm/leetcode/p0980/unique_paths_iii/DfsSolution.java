package com.nxy006.project.algorithm.leetcode.p0980.unique_paths_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 深度优先遍历
 * 时间复杂度：？，空间复杂度：O(nm)
 *
 * Runtime 0 ms    , beats 100.00 % of java submissions.
 * Memory  36.2 MB , beats  82.60 % of java submissions.
 * 11/02/2021 23:22
 */
public class DfsSolution {
    private static final int[][] walks = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int pathLength = 1, res = 0;                // pathLength 初始值为 1 ，表示终点的位置

    public int uniquePathsIII(int[][] grid) {
        int startX = -1, startY = -1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    pathLength++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        uniquePath(grid, startX, startY, 0);
        return res;
    }

    private void uniquePath(int[][] grid, int i, int j, int count) {
        if (grid[i][j] == 2) {
            if (count == pathLength) {
                res++;
            }
            return ;
        }

        grid[i][j] = 3;
        for(int[] walk : walks) {
            int nextX = i + walk[0], nextY = j + walk[1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length &&
                    (grid[nextX][nextY] == 0 || grid[nextX][nextY] == 2)) {
                uniquePath(grid, nextX, nextY, count+1);
            }
        }
        grid[i][j] = 0;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DfsSolution(), 2, "[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]");
        caseCheck(new DfsSolution(), 4, "[[1,0,0,0],[0,0,0,0],[0,0,0,2]]");
        caseCheck(new DfsSolution(), 0, "[[0,1],[2,0]]");
    }

    private static void caseCheck(DfsSolution solution, int expected, String gridStr) {
        CaseAssertUtils.assertEquals(expected, solution.uniquePathsIII(StructConvertUtils.convertToIntMatrix(gridStr)));
    }
}
