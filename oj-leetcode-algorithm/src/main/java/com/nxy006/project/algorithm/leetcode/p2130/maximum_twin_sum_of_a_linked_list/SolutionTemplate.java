package com.nxy006.project.algorithm.leetcode.p2130.maximum_twin_sum_of_a_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

public abstract class SolutionTemplate {
    abstract int pairSum(ListNode head);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, 6, "[5,4,2,1]");
        caseCheck(solution, 7, "[4,2,2,3]");
        caseCheck(solution, 100001, "[1,100000]");
    }

    private static void caseCheck(SolutionTemplate solution, int expected, String s) {
        CaseAssertUtils.assertEquals(expected, () -> solution.pairSum(StructConvertUtils.convertToListNode(s)));
    }
}
