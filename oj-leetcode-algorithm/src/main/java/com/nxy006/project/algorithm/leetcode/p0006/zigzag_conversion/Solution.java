package com.nxy006.project.algorithm.leetcode.p0006.zigzag_conversion;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j++) {
                if (j % n == i || j % n == (n - i)) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), "PAHNAPLSIIGYIR", "PAYPALISHIRING", 3);
        caseCheck(new Solution(), "PINALSIGYAHRPI", "PAYPALISHIRING", 4);
        caseCheck(new Solution(), "A", "A", 1);
    }

    private static void caseCheck(Solution solution, String expected, String s, int numRows) {
        CaseAssertUtils.assertEquals(expected, solution.convert(s, numRows));
    }
}
