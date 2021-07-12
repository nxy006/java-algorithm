package com.nxy006.project.algorithm.leetcode.p0023.merge_k_sorted_lists;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode res = new ListNode(0), node = res;
        while (true) {
            // 找到最小值
            ListNode minNode = lists[0];
            for(int i = 1; i < lists.length; i++) {
                if (lists[i] == null) continue;
                minNode = minNode == null || lists[i].val < minNode.val ? lists[i] : minNode;
            }
            // 未找到说明已全部遍历结束
            if (minNode == null) {
                break;
            }

            // 所有等于最小值的值
            for(int i = 0; i < lists.length; ) {
                if (lists[i] != null && lists[i].val == minNode.val) {
                    node.next = new ListNode(lists[i].val);
                    node = node.next;

                    lists[i] = lists[i].next;
                } else {
                    i++;
                }
            }
        }
        return res.next;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,1,2,3,4,4,5,6]", "[[1,4,5],[1,3,4],[2,6]]");
        caseCheck(new Solution(), "[]", "[]");
        caseCheck(new Solution(), "[]", "[[]]");
        // 自定义用例
        caseCheck(new Solution(), "[1,1,1,1,1,1,1,1,1]", "[[1,1,1],[1,1,1,1,1],[1]]");
        caseCheck(new Solution(), "[1,2,3,4,5,6,7,8,9]", "[[1,5,8],[2,3,6,7,9],[4]]");
    }

    private static void caseCheck(Solution solution, String expected, String listStr) {
        if ("[]".equals(listStr) || "[[]]".equals(listStr)) {
            CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected), solution.mergeKLists(new ListNode[]{}));
        } else {
            int[][] matrix = StructConvertUtils.convertToIntMatrix(listStr);
            ListNode[] lists = new ListNode[matrix.length];
            for(int i = 0; i < matrix.length; i++) {
                lists[i] = StructConvertUtils.convertToListNode(matrix[i]);
            }
            CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected), solution.mergeKLists(lists));
        }
    }
}
