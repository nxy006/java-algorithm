package com.nxy006.project.algorithm.leetcode.p0019.remove_nth_node_from_end_of_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   39 MB , beats   7.95 % of java submissions.
 * 07/09/2021 23:55
 */
public class TwoPointSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return null;
        ListNode res = new ListNode(0), l = res, r = res;
        res.next = head;
        while(n != 0) {
            r = r.next;
            n--;
        }

        while(r.next != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new TwoPointSolution(), "[1,2,3,5]", "[1,2,3,4,5]", 2);
        caseCheck(new TwoPointSolution(), "[]", "[1]", 1);
        caseCheck(new TwoPointSolution(), "[1]", "[1,2]", 1);
    }

    private static void caseCheck(TwoPointSolution solution, String expected, String listStr, int n) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected), solution.removeNthFromEnd(StructConvertUtils.convertToListNode(listStr), n));
    }
}
