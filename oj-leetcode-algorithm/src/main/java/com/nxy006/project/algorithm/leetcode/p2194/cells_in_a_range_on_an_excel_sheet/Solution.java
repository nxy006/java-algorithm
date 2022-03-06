package com.nxy006.project.algorithm.leetcode.p2194.cells_in_a_range_on_an_excel_sheet;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  4 ms    , beats 100.00 % of java submissions.
 * Memory   43.2 MB , beats  80.00 % of java submissions.
 * 03/07/2022 00:09
 */
public class Solution {
    public List<String> cellsInRange(String s) {
        char rowStart = s.charAt(1), rowEnd = s.charAt(4), colStart = s.charAt(0), colEnd = s.charAt(3);
        List<String> result = new ArrayList<>();
        for(int i = colStart; i <= colEnd; i++) {
            for(int j = rowStart; j <= rowEnd; j++) {
                result.add("" + (char) i + (char) j);
            }
        }
        return result;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[\"K1\",\"K2\",\"L1\",\"L2\"]","K1:L2");
        caseCheck(new Solution(), "[\"A1\",\"B1\",\"C1\",\"D1\",\"E1\",\"F1\"]","A1:F1");
        // 自定义用例
        caseCheck(new Solution(), "[\"A1\"]","A1:A1");
    }

    private static void caseCheck(Solution solution, String expectedArrStr, String s) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToStringList(expectedArrStr), solution.cellsInRange(s));
    }
}
