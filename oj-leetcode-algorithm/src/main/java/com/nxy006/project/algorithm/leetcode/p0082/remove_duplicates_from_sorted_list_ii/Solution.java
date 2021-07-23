package com.nxy006.project.algorithm.leetcode.p0082.remove_duplicates_from_sorted_list_ii;

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

        // node 是已经确定值不重复的最后的一个节点
        while(node != null) {
            // 当前节点：需要检查是否重复的第一个节点
            ListNode currNode = node.next;
            if (currNode == null) {
                break;
            }

            // 如果当前节点与下一节点相等则移动到不相等为止
            ListNode nextNode = currNode.next;
            boolean isChanged = false;
            while(nextNode != null && nextNode.val == currNode.val) {
                nextNode = nextNode.next;
                node.next = nextNode;
                isChanged = true;
            }

            // 如果移动了链表，则需要在原位置重新检查下一位置是否有重复值，不修改 node 的指向
            if (!isChanged) {
                node = nextNode;
            }
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,5]", "[1,2,3,3,4,4,5]");
        caseCheck(new Solution(), "[2,3]", "[1,1,1,2,3]");
        // 自定义用例
        caseCheck(new Solution(), "null", "[1,1,1,1,1]");
        caseCheck(new Solution(), "[1,2]", "[1,2,3,3,3,3]");
    }

    private static void caseCheck(Solution solution, String expected, String listStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                solution.deleteDuplicates(StructConvertUtils.convertToListNode(listStr)));
    }
}
