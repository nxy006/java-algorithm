package com.nxy006.project.algorithm.leetcode.p0143.reorder_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法
 * 将原链表分为前后两个部分，并将后半部分反转，再逐个拼接即可
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 99.88 % of java submissions.
 * Memory   41.4 MB , beats 91.19 % of java submissions.
 * 12/23/2021 01:10
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        ListNode firstNode = head, middleNode = head, node = head;
        while(node != null && node.next != null) {
            node = node.next.next;
            middleNode = middleNode.next;
        }

        ListNode secondNode = reverse(middleNode.next);
        middleNode.next = null;

        node = head;
        firstNode = firstNode.next;
        while(firstNode != null || secondNode != null) {
            if (secondNode != null) {
                node.next = secondNode;
                secondNode = secondNode.next;
                node = node.next;
            }
            if (firstNode != null) {
                node.next = firstNode;
                firstNode = firstNode.next;
                node = node.next;
            }
        }
        node.next = null;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head.next, prevNode = head;
        prevNode.next = null;
        while(node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;

            prevNode = node;
            node = nextNode;
        }
        return prevNode;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,4,2,3]", "[1,2,3,4]");
        caseCheck(new Solution(), "[1,5,2,4,3]", "[1,2,3,4,5]");
        // 自定义用例
        caseCheck(new Solution(), "[1]", "[1]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String listStr) {
        ListNode head = StructConvertUtils.convertToListNode(listStr);
        solution.reorderList(head);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expectedStr), head);
    }
}
