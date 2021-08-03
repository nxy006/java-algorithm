package com.nxy006.project.algorithm.leetcode.p0092.reverse_linked_list_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   36.9 MB , beats  12.69 % of java submissions.
 * 08/03/2021 22:47
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right || head == null || left <= 0) return head;
        ListNode res = new ListNode(0), leftNode = res, rightNode = res, prevNode = null;
        res.next = head;

        int diff = right - left;
        while(diff-- > 0) {
            rightNode = rightNode.next;
        }
        while(left-- > 0) {
            prevNode = leftNode;
            leftNode = leftNode.next;
            rightNode = rightNode.next;

        }

        prevNode.next = reverse(leftNode, rightNode.next);
        return res.next;
    }

    private ListNode reverse(ListNode leftNode, ListNode rightNode) {
        ListNode node = leftNode, prevNode = rightNode;
        while(node != rightNode) {
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
        caseCheck(new Solution(), "[1,4,3,2,5]", "[1,2,3,4,5]", 2, 4);
        caseCheck(new Solution(), "[5]", "[5]", 1, 1);
        // 自定义用例
        caseCheck(new Solution(), "[5,4,3,2,1]", "[1,2,3,4,5]", 1, 5);
        caseCheck(new Solution(), "[4,3,2,1,5]", "[1,2,3,4,5]", 1, 4);
        caseCheck(new Solution(), "[1,5,4,3,2]", "[1,2,3,4,5]", 2, 5);
    }

    private static void caseCheck(Solution solution, String expected, String listStr, int left, int right) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expected),
                solution.reverseBetween(StructConvertUtils.convertToListNode(listStr), left, right));
    }
}
