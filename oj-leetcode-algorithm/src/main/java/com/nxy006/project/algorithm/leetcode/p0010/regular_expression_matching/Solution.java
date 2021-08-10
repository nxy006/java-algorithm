package com.nxy006.project.algorithm.leetcode.p0010.regular_expression_matching;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 递归算法
 *
 * Runtime  1419 ms , beats 5.04 % of java submissions.
 * Memory   37.4 MB , beats 95.68 % of java submissions.
 * 08/10/2021 23:22
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        // 表达式已经结束，但字符串尚未结束，匹配失败
        if (j >= p.length()) {
            return false;
        }

        boolean anyCount = j+1 < p.length() && p.charAt(j+1) == '*';
        // 当前字符串匹配可以匹配表达式
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            if (anyCount) {
                // 匹配零次，匹配一次（还能继续匹配），最后匹配一次（不能继续匹配）
                // 【错误】：这里曾经少考虑一种情况 （2021-08-10）
                return isMatch(s, i, p, j+2) || isMatch(s, i+1, p, j) || isMatch(s, i+1, p, j+2);
            } else {
                // 匹配下一位置表达式
                return isMatch(s, i+1, p, j+1);
            }
        } else {
            // 当前字符串匹配不能匹配表达式
            if (anyCount) {
                // 匹配零次
                return isMatch(s, i, p, j+2);
            } else {
                // 匹配失败
                return false;
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aa", "a"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aa", "a*"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("ab", ".*"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aab", "c*a*b"));
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("mississippi", "mis*is*p*."));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("a", "ab*"));
    }
}
