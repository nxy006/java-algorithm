package com.nxy006.project.algorithm.leetcode.p0083.remove_duplicates_from_sorted_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(Integer.MAX_VALUE), node = res;
        res.next = head;
        while(node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2]", "[1,1,2]");
        caseCheck(new Solution(), "[1,2,3]", "[1,1,2,3,3]");
        // 自定义用例
        caseCheck(new Solution(), "[1]", "[1,1,1,1,1]");
        caseCheck(new Solution(), "null", "null");
    }

    private static void caseCheck(Solution solution, String expected, String listStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                solution.deleteDuplicates(StructConvertUtils.convertToListNode(listStr)));
    }
}
