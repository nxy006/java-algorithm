package com.nxy006.project.algorithm.leetcode.p0115.distinct_subsequences;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(nm)，空间复杂度：O(nm)
 *
 * Runtime  21 ms   , beats 15.73 % of java submissions.
 * Memory   43.3 MB , beats 20.26 % of java submissions.
 * 09/20/2021 14:07
 */
public class DpSolution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        if (n < m) return 0;

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for(int j = 0; j < m; j++) {
                dp[i+1][j+1] = s.charAt(i) == t.charAt(j) ? dp[i][j]+dp[i][j+1] : dp[i][j+1];
            }
        }
        return dp[n][m];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(3, new DpSolution().numDistinct("rabbbit", "rabbit"));
        CaseAssertUtils.assertEquals(5, new DpSolution().numDistinct("babgbag", "bag"));
        // 自定义用例
        CaseAssertUtils.assertEquals(5, new DpSolution().numDistinct("kkbabgbag", "bag"));
        CaseAssertUtils.assertEquals(0, new DpSolution().numDistinct("abcagage", "edf"));
    }
}
