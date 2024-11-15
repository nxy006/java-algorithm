package com.nxy006.project.algorithm.leetcode.p0649.dota2_senate;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

public abstract class SolutionTemplate {
    abstract String predictPartyVictory(String senate);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "Radiant", "RD");
        caseCheck(solution, "Dire", "RDD");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String s) {
        CaseAssertUtils.assertEquals(expected, () -> solution.predictPartyVictory(s));
    }
}
