package com.nxy006.project.algorithm.leetcode.p0328.odd_even_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   38.6 MB , beats  73.35 % of java submissions.
 * 12/02/2021 23:30
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddNode = head, evenNode = head.next, evenHead = evenNode, node = evenNode.next;
        int i = 1;
        while(node != null) {
            ListNode nextNode = node.next;
            if ((i++) % 2 == 1) {
                oddNode.next = node;
                oddNode = oddNode.next;
            } else {
                evenNode.next = node;
                evenNode = evenNode.next;
            }
            node = nextNode;
        }
        oddNode.next = evenHead;
        evenNode.next = null;
        return head;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,3,5,2,4]", "[1,2,3,4,5]");
        caseCheck(new Solution(), "[2,3,6,7,1,5,4]", "[2,1,3,5,6,4,7]");
        // 自定义用例
        caseCheck(new Solution(), "[1,1,1,1,1,1,2,2,2,2,2]", "[1,2,1,2,1,2,1,2,1,2,1]");
        caseCheck(new Solution(), "[1,1,1,1,1,2,2,2,2,2]", "[1,2,1,2,1,2,1,2,1,2]");
        caseCheck(new Solution(), "[1]", "[1]");
        caseCheck(new Solution(), "[]", "[]");
    }

    private static void caseCheck(Solution solution, String expected, String listStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expected),
                solution.oddEvenList(StructConvertUtils.convertToListNode(listStr)));
    }
}
