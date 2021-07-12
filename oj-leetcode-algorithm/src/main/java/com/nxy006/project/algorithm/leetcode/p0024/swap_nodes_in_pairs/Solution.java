package com.nxy006.project.algorithm.leetcode.p0024.swap_nodes_in_pairs;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0), node = res;
        res.next = head;

        while(node.next != null && node.next.next != null) {
            ListNode second = node.next.next, nextNode = second.next;

            second.next = node.next;
            second.next.next = nextNode;
            node.next = second;

            node = second.next;
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[2,1,4,3]", "[1,2,3,4]");
        caseCheck(new Solution(), "[]", "[]");
        caseCheck(new Solution(), "[1]", "[1]");
        // 自定义用例
        caseCheck(new Solution(), "[2,1,4,3,6,5,7]", "[1,2,3,4,5,6,7]");
    }

    private static void caseCheck(Solution solution, String expected, String listStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected), solution.swapPairs(StructConvertUtils.convertToListNode(listStr)));
    }
}
