package com.nxy006.project.algorithm.leetcode.p0064.minimum_path_sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(mn)，空间复杂度：O(1)
 *
 * Runtime  2 ms    , beats 81.83 % of java submissions.
 * Memory   41.3 MB , beats 97.00 % of java submissions.
 * 07/23/2021 23:56
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            grid[i][0] = (i == 0 ? 0 : grid[i-1][0]) + grid[i][0];
            for(int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Integer.min(i == 0 ? Integer.MAX_VALUE : grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 7, "[[1,3,1],[1,5,1],[4,2,1]]");
        caseCheck(new Solution(), 12, "[[1,2,3],[4,5,6]]");
        // 自定义用例
        caseCheck(new Solution(), 4,"[[1,1],[1,1],[1,1]]");
        caseCheck(new Solution(), 8,"[[1,100],[1,100],[5,1]]");
    }

    private static void caseCheck(Solution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.minPathSum(StructConvertUtils.convertToIntMatrix(numsStr)));
    }
}
