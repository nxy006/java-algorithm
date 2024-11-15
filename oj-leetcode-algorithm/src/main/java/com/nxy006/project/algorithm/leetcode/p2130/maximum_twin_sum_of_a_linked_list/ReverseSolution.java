package com.nxy006.project.algorithm.leetcode.p2130.maximum_twin_sum_of_a_linked_list;

import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 快慢指针+反转链表
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  5 ms    , beats 69.15 % of java submissions.
 * Memory   63.4 MB , beats 70.58 % of java submissions.
 * 15/11/2024 19:50
 */
public class ReverseSolution extends SolutionTemplate {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current1 = head, current2 = reverse(slow.next);
        int result = 0;
        while(current1 != null && current2 != null) {
            result = Math.max(result, current1.val + current2.val);
            current1 = current1.next;
            current2 = current2.next;
        }
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        processCaseTest(new ReverseSolution());
    }
}
