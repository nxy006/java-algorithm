package com.nxy006.project.algorithm.leetcode.p0008.string_to_integer_atoi;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int myAtoi(String s) {
        long res = 0, flag = 1;
        s = findValidString(s);
        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                if (i == 0) {
                    flag = c == '+' ? 1 : -1;
                } else {
                    return 0;
                }
            } else if (c >= '0' && c <= '9') {
                int num = s.charAt(i) - '0';
                res = res * 10 + num * flag;
            } else {
                return 0;
            }

            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    private String findValidString(String s) {
        boolean allowLeadingWhite = true;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                if (allowLeadingWhite) continue;
                else break;
            }

            sb.append(c);
            allowLeadingWhite = false;
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(42, new Solution().myAtoi("42"));
        CaseAssertUtils.assertEquals(-42, new Solution().myAtoi("   -42"));
        CaseAssertUtils.assertEquals(4193, new Solution().myAtoi("4193 with words"));
        CaseAssertUtils.assertEquals(0, new Solution().myAtoi("words and 987"));
        CaseAssertUtils.assertEquals(-2147483648, new Solution().myAtoi("-91283472332"));
        CaseAssertUtils.assertEquals(32, new Solution().myAtoi("0032"));
        CaseAssertUtils.assertEquals(3, new Solution().myAtoi("3.14159"));
        CaseAssertUtils.assertEquals(-12, new Solution().myAtoi("  -0012a42"));
    }
}
