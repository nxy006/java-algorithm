package com.nxy006.project.algorithm.leetcode.p0680.valid_palindrome_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  8 ms    , beats  80.00 % of java submissions.
 * Memory   55.3 MB , beats  15.92 % of java submissions.
 * 04/02/2022 22:49
 */
public class TwoPointSolution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        for(; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
        }

        if (l >= r) {
            return true;
        } else {
            return isVaild(s, l, r-1) || isVaild(s, l+1, r);
        }
    }

    private boolean isVaild(String s, int l, int r) {
        for(; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointSolution(), true,"aba");
        caseCheck(new TwoPointSolution(), true,"abca");
        caseCheck(new TwoPointSolution(), false,"abc");
        // 自定义用例
        caseCheck(new TwoPointSolution(), true,"aaaaaaaaaaaaaaaaa");
        caseCheck(new TwoPointSolution(), true,"aaaaaaaaaaaaab");
        caseCheck(new TwoPointSolution(), true,"baaaaaaaaaaaaaaaaaaaaaaaba");
        caseCheck(new TwoPointSolution(), false,"baaaaaaaaaac");
    }

    private static void caseCheck(TwoPointSolution solution, boolean expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.validPalindrome(s));
    }
}
