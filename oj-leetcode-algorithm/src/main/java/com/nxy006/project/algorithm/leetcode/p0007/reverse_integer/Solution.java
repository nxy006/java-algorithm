package com.nxy006.project.algorithm.leetcode.p0007.reverse_integer;


import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int reverse(int x) {
        int flag = x >= 0 ? 1 : -1;
        x = Math.abs(x);

        int res = 0;
        while(x != 0) {
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res * flag;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(321, new Solution().reverse(123));
        CaseAssertUtils.assertEquals(-321, new Solution().reverse(-123));
        CaseAssertUtils.assertEquals(21, new Solution().reverse(120));
        CaseAssertUtils.assertEquals(0, new Solution().reverse(0));
        CaseAssertUtils.assertEquals(0, new Solution().reverse(Integer.MAX_VALUE));
    }
}
