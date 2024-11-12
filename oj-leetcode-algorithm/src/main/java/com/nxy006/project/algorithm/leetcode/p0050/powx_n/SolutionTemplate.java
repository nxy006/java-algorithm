package com.nxy006.project.algorithm.leetcode.p0050.powx_n;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

public abstract class SolutionTemplate {
    abstract public double myPow(double x, int n);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, 1024.00000, 2.00000, 10);
        caseCheck(solution, 9.26100, 2.10000, 3);
        caseCheck(solution, 0.25000, 2.00000, -2);
        // 失败用例
        caseCheck(solution, 1.00000, 1.00000, 2147483647);
        caseCheck(solution, 0.00000, 2.00000, -2147483648);
        caseCheck(solution, 1.00000, -1.00000, -2147483648);
    }

    private static void caseCheck(SolutionTemplate solution, double expected, double x, int n) {
        CaseAssertUtils.assertEquals(expected, () -> solution.myPow(x, n));
    }
}
