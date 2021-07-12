package com.nxy006.project.algorithm.leetcode.p0021.merge_two_sorted_lists;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), node = res;
        while (l1 != null || l2 != null) {
            if (l2 == null || l1 != null && l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
            node.next = null;
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,1,2,3,4,4]", "[1,2,4]", "[1,3,4]");
        caseCheck(new Solution(), "[]", "[]", "[]");
        caseCheck(new Solution(), "[0]", "[]", "[0]");
        // 自定义用例
        caseCheck(new Solution(), "[1,1,2,3]", "[1,1,2]", "[3]");
        caseCheck(new Solution(), "[1,1,1,1,1,1,1]", "[1,1,1,1,1,1]", "[1]");
    }

    private static void caseCheck(Solution solution, String expected, String list1Str, String list2Str) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expected),
                solution.mergeTwoLists(StructConvertUtils.convertToListNode(list1Str), StructConvertUtils.convertToListNode(list2Str)));
    }
}
