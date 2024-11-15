package com.nxy006.project.algorithm.leetcode.p0206.reverse_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

public abstract class SolutionTemplate {
    abstract ListNode reverseList(ListNode head);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "[2,1]", "[1,2]");
        caseCheck(solution, "[]", "[]");
        caseCheck(solution, "[5,4,3,2,1]", "[1,2,3,4,5]");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String s) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                () -> solution.reverseList(StructConvertUtils.convertToListNode(s)));
    }
}
