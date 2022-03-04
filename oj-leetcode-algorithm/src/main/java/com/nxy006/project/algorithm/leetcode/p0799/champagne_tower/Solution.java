package com.nxy006.project.algorithm.leetcode.p0799.champagne_tower;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 模拟解法
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 *
 * Runtime  14 ms   , beats  40.64 % of java submissions.
 * Memory   49.3 MB , beats  38.81 % of java submissions.
 * 03/05/2022 00:42
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] arr = new double[100], next = new double[100];
        arr[0] = poured;
        for(int i = 0; i < query_row; i++) {
            for(int j = 0; j < i+1; j++) {
                next[j]   += Double.max((arr[j] - 1) / 2, 0.0);
                next[j+1] += Double.max((arr[j] - 1) / 2, 0.0);
            }

            arr = next;
            next = new double[100];
        }
        return arr[query_glass] > 1 ? 1.0 : arr[query_glass] / 1.0;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(0.0, new Solution().champagneTower(1,1,1));
        CaseAssertUtils.assertEquals(0.5, new Solution().champagneTower(2,1,1));
        CaseAssertUtils.assertEquals(1.0, new Solution().champagneTower(100000009,33,17));
        // 自定义用例
        CaseAssertUtils.assertEquals(0.25, new Solution().champagneTower(4, 2, 2));
        CaseAssertUtils.assertEquals(0.0, new Solution().champagneTower(89, 99, 99));
    }
}
