package com.nxy006.project.algorithm.leetcode.p0086.partition_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerRoot = new ListNode(0), smallerNode = smallerRoot, greaterRoot = new ListNode(0), greaterNode = greaterRoot, node = head;
        while(node != null) {
            ListNode nextNode = node.next;
            node.next = null;
            if (node.val < x) {
                smallerNode.next = node;
                smallerNode = smallerNode.next;
            } else {
                greaterNode.next = node;
                greaterNode = greaterNode.next;
            }
            node = nextNode;
        }

        smallerNode.next = greaterRoot.next;
        return smallerRoot.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,2,4,3,5]", "[1,4,3,2,5,2]", 3);
        caseCheck(new Solution(), "[1,2]", "[2,1]", 2);
        // 自定义用例
        caseCheck(new Solution(), "[1,2,3,4]", "[1,2,3,4]", 0);
        caseCheck(new Solution(), "[1,2,3,4]", "[1,2,3,4]", 5);
        caseCheck(new Solution(), "[1,1,1,1]", "[1,1,1,1]", 1);
        caseCheck(new Solution(), "[2,1,4,3]", "[4,3,2,1]", 3);
    }

    private static void caseCheck(Solution solution, String expected, String l1Str, int x) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                solution.partition(StructConvertUtils.convertToListNode(l1Str), x));
    }
}
