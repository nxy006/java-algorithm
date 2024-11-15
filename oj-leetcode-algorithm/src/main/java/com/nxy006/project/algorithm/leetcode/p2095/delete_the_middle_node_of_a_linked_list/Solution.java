package com.nxy006.project.algorithm.leetcode.p2095.delete_the_middle_node_of_a_linked_list;

import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 快慢指针
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  3 ms    , beats 99.89 % of java submissions.
 * Memory   63.8 MB , beats 63.56 % of java submissions.
 * 15/11/2024 19:08
 */
public class Solution extends SolutionTemplate {
    @Override
    ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
