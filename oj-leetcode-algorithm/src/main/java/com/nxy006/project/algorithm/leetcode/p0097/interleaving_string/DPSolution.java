package com.nxy006.project.algorithm.leetcode.p0097.interleaving_string;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 动态规划解法
 * 时间复杂度：O(nm)，空间复杂度：O(nm)
 *
 * Runtime  7 ms    , beats 29.15 % of java submissions.
 * Memory   37.4 MB , beats 59.49 % of java submissions.
 * 08/03/2021 23:01
 */
public class DPSolution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()  + s2.length() != s3.length()) return false;
        if (s1.length() == 0 || s2.length() == 0) {
            return s1.length() == 0 && s2.equals(s3) || s2.length() == 0 && s1.equals(s3);
        }

        // dp[i][j] 表示 s1[0..i) 到 s2[0..j) 范围能否构成 s3 相同长度范围
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 0; i < s1.length(); i++) {
            dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for(int j = 0; j < s2.length(); j++) {
            dp[0][j+1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
        }
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                dp[i+1][j+1] =
                        (s1.charAt(i) == s3.charAt(i+j+1) && dp[i][j+1]) ||
                        (s2.charAt(j) == s3.charAt(i+j+1) && dp[i+1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(true, new DPSolution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        CaseAssertUtils.assertEquals(false, new DPSolution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        CaseAssertUtils.assertEquals(true, new DPSolution().isInterleave("", "", ""));
        // 自定义用例
        CaseAssertUtils.assertEquals(true, new DPSolution().isInterleave("aaa", "", "aaa"));
        CaseAssertUtils.assertEquals(true, new DPSolution().isInterleave("aac", "", "aac"));
        CaseAssertUtils.assertEquals(true, new DPSolution().isInterleave("aaaaa", "aaaaa", "aaaaaaaaaa"));
        CaseAssertUtils.assertEquals(false, new DPSolution().isInterleave("baaaa", "aaaaa", "aaaaaaaaba"));
    }
}
