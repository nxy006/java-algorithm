package com.nxy006.project.algorithm.leetcode.p0933.number_of_recent_calls;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

public abstract class SolutionTemplate {
    abstract int ping(int t);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    abstract CaseAssertUtils.SolutionProcessor getProcessor(int[] params);

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "[1, 2, 3, 3]", "[1, 100, 3001, 3002]");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String params) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expected),
                solution.getProcessor(StructConvertUtils.convertToIntArray(params)));
    }
}
