package com.nxy006.project.algorithm.leetcode.p0067.add_binary;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 常规解法
 *
 * Runtime  2 ms    , beats 75.20 % of java submissions.
 * Memory   38.9 MB , beats 60.22 % of java submissions.
 * 07/22/2021 23:46
 */
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int num = (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0) + carry;
            sb.insert(0, num % 2);
            carry = num / 2;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("100", new Solution().addBinary("11", "1"));
        CaseAssertUtils.assertEquals("10101", new Solution().addBinary("1010", "1011"));
        // 自定义用例
        CaseAssertUtils.assertEquals("10", new Solution().addBinary("1", "1"));
        CaseAssertUtils.assertEquals("0", new Solution().addBinary("0", "0"));
        CaseAssertUtils.assertEquals("1", new Solution().addBinary("0", "1"));
        CaseAssertUtils.assertEquals("1001", new Solution().addBinary("1000", "1"));
    }
}
