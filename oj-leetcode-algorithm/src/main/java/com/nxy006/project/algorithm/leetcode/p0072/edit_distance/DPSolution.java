package com.nxy006.project.algorithm.leetcode.p0072.edit_distance;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(nm)，空间复杂度：O(nm)
 *
 * Runtime  5 ms    , beats 61.33 % of java submissions.
 * Memory   38.8 MB , beats 83.63 % of java submissions.
 * 07/22/2021 23:49
 */
public class DPSolution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    // 当前值不相等时，可以从前一位置增减，或从上一个位置字符替换得到
                    dp[i+1][j+1] = Integer.min(Integer.min(dp[i][j+1], dp[i+1][j]) + 1, dp[i][j] + 1);;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(3, new DPSolution().minDistance("horse", "ros"));
        CaseAssertUtils.assertEquals(5, new DPSolution().minDistance("intention", "execution"));
        // 自定义用例
        CaseAssertUtils.assertEquals(7, new DPSolution().minDistance("", "abcdefg"));
        CaseAssertUtils.assertEquals(4, new DPSolution().minDistance("abd", "abcdefg"));
        CaseAssertUtils.assertEquals(3, new DPSolution().minDistance("abddddg", "abcdefg"));
        CaseAssertUtils.assertEquals(1, new DPSolution().minDistance("word", "world"));
        CaseAssertUtils.assertEquals(2, new DPSolution().minDistance("race", "raise"));
    }
}
