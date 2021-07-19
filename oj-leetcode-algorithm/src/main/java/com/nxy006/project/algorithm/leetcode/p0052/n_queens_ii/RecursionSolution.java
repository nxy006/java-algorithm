package com.nxy006.project.algorithm.leetcode.p0052.n_queens_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;


/**
 * 递归解法
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   35.6 MB , beats  87.83 % of java submissions.
 * 07/19/2021 23:16
 */
public class RecursionSolution {
    public int totalNQueens(int n) {
        return process(n, new boolean[n], new boolean[4*n], new boolean[4*n], 0);
    }

    private int process(int n, boolean[] cols, boolean[] first, boolean[] second, int k) {
        if (k == n) {
            return 1;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if (cols[i] || first[n+k-i] || second[n+i+k]) continue;

            cols[i] = first[n+k-i] = second[n+i+k] = true;
            cnt += process(n, cols, first, second, k+1);
            cols[i] = first[n+k-i] = second[n+i+k] = false;
        }
        return cnt;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(2, new RecursionSolution().totalNQueens(4));
        CaseAssertUtils.assertEquals(1, new RecursionSolution().totalNQueens(1));
    }
}
