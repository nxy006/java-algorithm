package com.nxy006.project.algorithm.leetcode.p0002.add_two_numbers;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 模拟解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  2 ms    , beats 69.58 % of java submissions.
 * Memory   39.5 MB , beats 37.97 % of java submissions.
 * 07/06/2021 12:02
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SimulationSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0), node = res;
        while(l1 != null || l2 != null) {
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = num / 10;
            num %= 10;

            node.next = new ListNode(num);
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new SimulationSolution(), "[7,0,8]", "[2,4,3]", "[5,6,4]");
        caseCheck(new SimulationSolution(), "[0]", "[0]", "[0]");
        caseCheck(new SimulationSolution(), "[8,9,9,9,0,0,0,1]", "[9,9,9,9,9,9,9]", "[9,9,9,9]");
    }

    private static void caseCheck(SimulationSolution solution, String expected, String l1Str, String l2Str) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                solution.addTwoNumbers(StructConvertUtils.convertToListNode(l1Str), StructConvertUtils.convertToListNode(l2Str)));
    }
}
