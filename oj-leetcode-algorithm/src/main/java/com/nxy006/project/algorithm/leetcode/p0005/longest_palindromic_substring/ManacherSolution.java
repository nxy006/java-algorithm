package com.nxy006.project.algorithm.leetcode.p0005.longest_palindromic_substring;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * Manacher 算法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  51 ms   , beats 46.04 % of java submissions.
 * Memory   38.9 MB , beats 79.84 % of java submissions.
 * 07/06/2021 14:54
 */
public class ManacherSolution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        s = sb.toString();

        int r = -1, j = -1, maxLen = 0, res = 0;
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int len;
            if (i < r) {
                int minLen = Integer.min(dp[2*j-i], r-i);
                len = maxLenWithExpend(s, i, minLen);
            } else {
                len = maxLenWithExpend(s, i, 0);
            }
            dp[i] = len;

            if (i+len > r) {
                r = len;
                j = i;
            }
            if (len > maxLen) {
                maxLen = len;
                res = i;
            }
        }

        sb = new StringBuilder();
        for(int i = res-maxLen; i <= res+maxLen; i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private int maxLenWithExpend(String s, int i, int len) {
        for(len = len+1; i-len >= 0 && i+len < s.length(); len++) {
            if (s.charAt(i-len) != s.charAt(i+len)) {
                return len-1;
            }
        }
        return len-1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new ManacherSolution(), "bab", "babad");
        caseCheck(new ManacherSolution(), "bb", "cbbd");
        caseCheck(new ManacherSolution(), "a", "a");
        caseCheck(new ManacherSolution(), "a", "ac");
    }

    private static void caseCheck(ManacherSolution solution, String expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.longestPalindrome(s));
    }
}
