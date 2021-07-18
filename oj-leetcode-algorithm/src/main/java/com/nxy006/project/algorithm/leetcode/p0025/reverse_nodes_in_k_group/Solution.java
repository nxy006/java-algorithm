package com.nxy006.project.algorithm.leetcode.p0025.reverse_nodes_in_k_group;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.2 MB , beats  63.96 % of java submissions.
 * 07/18/2021 23:26
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode res = new ListNode(0), node = res, curr = res.next;
        res.next = head;
        while(node != null) {
            curr = node;
            for(int i = 0; i < k; i++) {
                if (curr == null) return res.next;
                curr = curr.next;
            }
            node = reverse(node, curr);
        }
        return res.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (tail == null) return null;

        ListNode node = head.next, prev = tail.next, start = head.next;
        while(node != tail) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = tail;
        tail.next = prev;
        return start;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[2,1,4,3,5]", "[1,2,3,4,5]", 2);
        caseCheck(new Solution(), "[3,2,1,4,5]", "[1,2,3,4,5]", 3);
        caseCheck(new Solution(), "[1,2,3,4,5]", "[1,2,3,4,5]", 1);
        caseCheck(new Solution(), "[1]", "[1]", 1);
    }

    private static void caseCheck(Solution solution, String expected, String listStr, int k) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expected),
                solution.reverseKGroup(StructConvertUtils.convertToListNode(listStr), k));
    }
}
