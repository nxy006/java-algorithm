package com.nxy006.project.algorithm.leetcode.p1071.greatest_common_divisor_of_strings;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

public abstract class SolutionTemplate {
    abstract String gcdOfStrings(String str1, String str2);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "ABC", "ABCABC", "ABC");
        caseCheck(solution, "AB", "ABABAB", "ABAB");
        caseCheck(solution, "", "LEET", "CODE");
        // 自定义用例
        caseCheck(solution, "A", "AAAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAAAA");
        caseCheck(solution, "AAA", "AAAAAAAAA", "AAAAAAAAAAAAAAAAAAAAA");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String str1, String str2) {
        CaseAssertUtils.assertEquals(expected, () -> solution.gcdOfStrings(str1, str2));
    }
}
