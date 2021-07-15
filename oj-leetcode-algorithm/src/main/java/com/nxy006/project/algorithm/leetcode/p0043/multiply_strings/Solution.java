package com.nxy006.project.algorithm.leetcode.p0043.multiply_strings;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 数学解法
 * 时间复杂度：O(mn)，空间复杂度：O(m+n)，m、n 分别是 num1、nums2 的长度
 *
 * Runtime  4 ms  , beats 57.59 % of java submissions.
 * Memory   39 MB , beats 60.64 % of java submissions.
 * 07/15/2021 23:19
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int j = 0, num = 0;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < num1.length() + num2.length() - 1; t++) {
            // i 和 j 表示倒数第几位数
            for(int i = 0; i < num1.length(); i++) {
                if ((j = t-i) >= 0 && j < num2.length()) {
                    num += (num1.charAt(num1.length()-1-i) - '0') * (num2.charAt(num2.length()-1-j) - '0');
                }
            }

            sb.insert(0, num % 10);
            num = num / 10;
        }
        if (num != 0) {
            sb.insert(0, num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("6", new Solution().multiply("2", "3"));
        CaseAssertUtils.assertEquals("56088", new Solution().multiply("123", "456"));
        // 自定义用例
        CaseAssertUtils.assertEquals("100000000", new Solution().multiply("10000", "10000"));
        CaseAssertUtils.assertEquals("268250018574", new Solution().multiply("489898", "547563"));
        CaseAssertUtils.assertEquals("0", new Solution().multiply("0", "547563"));
    }
}
