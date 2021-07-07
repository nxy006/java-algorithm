package com.nxy006.project.algorithm.leetcode.p0006.zigzag_conversion;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 按行遍历算法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  52 ms   , beats  9.30 % of java submissions.
 * Memory   38.6 MB , beats 99.52 % of java submissions.
 * 07/08/2021 01:20
 */
public class VisitByRowSolution {
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
        caseCheck(new VisitByRowSolution(), "PAHNAPLSIIGYIR", "PAYPALISHIRING", 3);
        caseCheck(new VisitByRowSolution(), "PINALSIGYAHRPI", "PAYPALISHIRING", 4);
        caseCheck(new VisitByRowSolution(), "A", "A", 1);
    }

    private static void caseCheck(VisitByRowSolution solution, String expected, String s, int numRows) {
        CaseAssertUtils.assertEquals(expected, solution.convert(s, numRows));
    }
}
