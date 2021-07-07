package com.nxy006.project.algorithm.leetcode.p0009.palindrome_number;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 数学算法
 * 时间复杂度：O(log_10^{n})，空间复杂度：O(1)
 *
 * Runtime  8 ms    , beats 42.07 % of java submissions.
 * Memory   38.2 MB , beats 73.53 % of java submissions.
 * 07/08/2021 01:40
 */
public class MathSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long l = 1, r = maxSteNumber(x);
        while(l < r) {
            if ((x / l) % 10 != (x / r) % 10) {
                return false;
            }
            l *= 10;
            r /= 10;
        }
        return true;
    }

    private long maxSteNumber(int num) {
        long res = 1;
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
        CaseAssertUtils.assertEquals(true, new MathSolution().isPalindrome(1874994781));
    }
}
