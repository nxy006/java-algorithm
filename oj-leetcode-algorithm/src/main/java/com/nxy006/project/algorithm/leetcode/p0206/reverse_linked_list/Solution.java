package com.nxy006.project.algorithm.leetcode.p0206.reverse_linked_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法（遍历）
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.8 MB , beats  17.02 % of java submissions.
 * 09/08/2021 23:11
 */
public class Solution extends SolutionTemplate {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode node = head, prev = null;
        while(node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
