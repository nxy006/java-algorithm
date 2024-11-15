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
public class Solution extends SolutionTemplate {
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
        processCaseTest(new Solution());
    }
}
