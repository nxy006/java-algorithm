package com.nxy006.project.algorithm.sword_to_offer.p19.regular_expressions_matching;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 *       表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 *       中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 *       和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/19_RegularExpressionsMatching
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * 执行用时：1379 ms, 在所有 Java 提交中击败了  5.03 % 的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了 99.27 % 的用户
 * 2021/08/10 23:37
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
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
        // Leetcode-CN 题目示例
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aa", "a"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aa", "a*"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("ab", ".*"));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aab", "c*a*b"));
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("mississippi", "mis*is*p*."));
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("a", "ab*"));
        // 书籍用例
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("", ""));                     // 01
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("", ".*"));                   // 02
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("", "."));                   // 03
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("", "c*"));                   // 04
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("a", ".*"));                  // 05
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("a", "a."));                 // 06
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("a", ""));                   // 07
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("a", "."));                   // 08
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("a", "ab*"));                 // 09
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("a", "ab*a"));               // 10
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aa", "aa"));                 // 11
        CaseAssertUtils.assertEquals(true, new Solution().isMatch( "aa", "a*"));                // 12
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aa", ".*"));                 // 13
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aa", "."));                 // 14
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("ab", ".*"));                 // 15
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("ab", ".*"));                 // 16
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", "aa*"));               // 17
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aaa", "aa.a"));             // 18
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", "a.a"));               // 19
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aaa", ".a"));               // 20
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", "a*a"));               // 21
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aaa", "ab*a"));             // 22
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", "ab*ac*a"));           // 23
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", "ab*a*c*a"));          // 24
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaa", ".*"));                // 25
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aab", "c*a*b"));             // 26
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("aaca", "ab*a*c*a"));         // 27
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("aaba", "ab*a*c*a"));        // 28
        CaseAssertUtils.assertEquals(true, new Solution().isMatch("bbbba", ".*a*a"));           // 29
        CaseAssertUtils.assertEquals(false, new Solution().isMatch("bcbbabab", ".*a*a"));       // 30



    }
}
