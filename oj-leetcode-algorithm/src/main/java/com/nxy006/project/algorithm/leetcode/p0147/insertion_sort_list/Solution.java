package com.nxy006.project.algorithm.leetcode.p0147.insertion_sort_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 两轮遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  30 ms   , beats 41.14 % of java submissions.
 * Memory   38.5 MB , beats 90.41 % of java submissions.
 * 12/15/2021 23:01
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 新增头节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        // current：当前待插入节点的上一个节点
        ListNode current = head;
        while(current != null && current.next != null) {
            boolean nextChange = false;
            ListNode nextCurrent = current.next;

            // node：当前遍历节点的上一个节点
            for(ListNode node = newHead; node != current; node = node.next) {
                if (current.next.val <= node.next.val) {
                    // Remove
                    ListNode currentNext = current.next;
                    current.next = nextCurrent.next;
                    // Add
                    currentNext.next = node.next;
                    node.next = currentNext;

                    nextChange = true;
                    break;
                }
            }

            // 如果待插入节点已完成插入，则 current 已指向下一个待处理的节点，不需要重新指向
            if (!nextChange) {
                current = nextCurrent;
            }
        }
        return newHead.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,3,4]", "[4,2,1,3]");
        caseCheck(new Solution(), "[-1,0,3,4,5]", "[-1,5,3,4,0]");
        caseCheck(new Solution(), "[1,1]", "[1,1]");
        // 自定义用例
        caseCheck(new Solution(), "[1]", "[1]");
        caseCheck(new Solution(), "[1,2,3,4]", "[1,2,3,4]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String listStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToListNode(expectedStr),
                solution.insertionSortList(StructConvertUtils.convertToListNode(listStr)));
    }
}
