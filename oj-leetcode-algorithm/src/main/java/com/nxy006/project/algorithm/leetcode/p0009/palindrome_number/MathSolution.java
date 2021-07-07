package com.nxy006.project.algorithm.leetcode.p0009.palindrome_number;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class MathSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int l = 1, r = maxSteNumber(x);
        while(l < r) {
            if ((x / l) % 10 != (x / r) % 10) {
                return false;
            }
            l *= 10;
            r /= 10;
        }
        return true;
    }

    private int maxSteNumber(int num) {
        int res = 1;
        while(res * 10 <= num) {
            res *= 10;
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(true,  new MathSolution().isPalindrome(121));
        CaseAssertUtils.assertEquals(false, new MathSolution().isPalindrome(-121));
        CaseAssertUtils.assertEquals(false, new MathSolution().isPalindrome(10));
        CaseAssertUtils.assertEquals(false, new MathSolution().isPalindrome(-101));
        CaseAssertUtils.assertEquals(true, new MathSolution().isPalindrome(0));
    }
}
