package com.nxy006.project.algorithm.leetcode.p0399.evaluate_division;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.List;

public abstract class SolutionTemplate {
    abstract double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "[6.00000,0.50000,-1.00000,1.00000,-1.00000]",
                "[[\"a\",\"b\"],[\"b\",\"c\"]]",
                "[2.0,3.0]",
                "[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]");
        caseCheck(solution, "[3.75000,0.40000,5.00000,0.20000]",
                "[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]",
                "[1.5,2.5,5.0]",
                "[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String equations, String values, String queries) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToDoubleArray(expected),
                () -> solution.calcEquation(
                        StructConvertUtils.convertToStringNestedList(equations),
                        StructConvertUtils.convertToDoubleArray(values),
                        StructConvertUtils.convertToStringNestedList(queries)));
    }
}
