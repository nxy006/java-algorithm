package com.nxy006.project.algorithm.leetcode.p0007.reverse_integer;


import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 数学算法
 * 时间复杂度：O(log_n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 100.00 % of java submissions.
 * Memory   36.3 MB , beats  32.12 % of java submissions.
 * 07/08/2021 01:24
 */
public class MathSolution {
    public int reverse(int x) {
        int flag = x >= 0 ? 1 : -1;
        x = Math.abs(x);

        int res = 0;
        while(x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res * flag;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(321, new MathSolution().reverse(123));
        CaseAssertUtils.assertEquals(-321, new MathSolution().reverse(-123));
        CaseAssertUtils.assertEquals(21, new MathSolution().reverse(120));
        CaseAssertUtils.assertEquals(0, new MathSolution().reverse(0));
        CaseAssertUtils.assertEquals(0, new MathSolution().reverse(Integer.MAX_VALUE));
        CaseAssertUtils.assertEquals(0, new MathSolution().reverse(-2147483648));
    }
}
