package com.nxy006.project.algorithm.leetcode.p0328.odd_even_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

public abstract class SolutionTemplate {
    abstract ListNode oddEvenList(ListNode head);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "[1,3,5,2,4]", "[1,2,3,4,5]");
        caseCheck(solution, "[2,3,6,7,1,5,4]", "[2,1,3,5,6,4,7]");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String s) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                () -> solution.oddEvenList(StructConvertUtils.convertToListNode(s)));
    }
}
