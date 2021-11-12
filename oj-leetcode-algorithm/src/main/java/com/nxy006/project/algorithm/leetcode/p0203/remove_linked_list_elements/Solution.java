package com.nxy006.project.algorithm.leetcode.p0203.remove_linked_list_elements;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime 1 ms    , beats 79.34 % of java submissions.
 * Memory  39.9 MB , beats 63.59 % of java submissions.
 * 11/13/2021 00:03
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode node = head, prev = newHead;
        while(node != null) {
            if (node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return newHead.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,3,4,5]", "[1,2,6,3,4,5,6]", 6);
        caseCheck(new Solution(), "[]", "[]", 1);
        caseCheck(new Solution(), "[]", "[7,7,7,7]", 7);
    }

    private static void caseCheck(Solution solution, String expectedListStr, String listStr, int val) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expectedListStr),
                solution.removeElements(StructConvertUtils.convertToListNode(listStr), val)
        );
    }
}
