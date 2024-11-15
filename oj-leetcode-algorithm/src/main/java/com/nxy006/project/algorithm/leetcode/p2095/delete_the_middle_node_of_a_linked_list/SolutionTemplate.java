package com.nxy006.project.algorithm.leetcode.p2095.delete_the_middle_node_of_a_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

public abstract class SolutionTemplate {
    abstract ListNode deleteMiddle(ListNode head);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, "[1,3,4,1,2,6]", "[1,3,4,7,1,2,6]");
        caseCheck(solution, "[1,2,4]", "[1,2,3,4]");
        caseCheck(solution, "[2]", "[2,1]");
    }

    private static void caseCheck(SolutionTemplate solution, String expected, String s) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                () -> solution.deleteMiddle(StructConvertUtils.convertToListNode(s)));
    }
}
