package com.nxy006.project.algorithm.leetcode.p0021.merge_two_sorted_lists;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 遍历解法
 * 时间复杂度：O(n+m)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 20.80 % of java submissions.
 * Memory   38.4 MB , beats 60.42 % of java submissions.
 * 07/13/2021 22:20
 */
public class TraversalSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), node = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
            node.next = null;
        }
        node.next = l1 != null ? l1 : l2;       // 其中至少一个链表遍历结束后，直接将另一链表接入到结果后面即可，无需比较
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TraversalSolution(), "[1,1,2,3,4,4]", "[1,2,4]", "[1,3,4]");
        caseCheck(new TraversalSolution(), "[]", "[]", "[]");
        caseCheck(new TraversalSolution(), "[0]", "[]", "[0]");
        // 自定义用例
        caseCheck(new TraversalSolution(), "[1,1,2,3]", "[1,1,2]", "[3]");
        caseCheck(new TraversalSolution(), "[1,1,1,1,1,1,1]", "[1,1,1,1,1,1]", "[1]");
    }

    private static void caseCheck(TraversalSolution solution, String expected, String list1Str, String list2Str) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expected),
                solution.mergeTwoLists(StructConvertUtils.convertToListNode(list1Str), StructConvertUtils.convertToListNode(list2Str)));
    }
}
