package com.nxy006.project.algorithm.leetcode.p0168.excel_sheet_column_title;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 数学解法（进制转换）
 * 时间复杂度：O(log_26^n)，空间复杂度：O(1)
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   36 MB , beats  84.24 % of java submissions.
 * 06/29/2021 22:26
 */
public class MathSolution {
    // 本题的进制转换中，没有零的出现，实际是用 [1, 26] 表示 [0, 25] ，即 26 进制，因而每次计算前需做减一操作
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0) {
            columnNumber--;
            sb.insert(0, (char)('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals("A", new MathSolution().convertToTitle(1));
        CaseAssertUtils.assertEquals("AB", new MathSolution().convertToTitle(28));
        CaseAssertUtils.assertEquals("ZY", new MathSolution().convertToTitle(701));
        CaseAssertUtils.assertEquals("FXSHRXW", new MathSolution().convertToTitle(2147483647));
    }
}
