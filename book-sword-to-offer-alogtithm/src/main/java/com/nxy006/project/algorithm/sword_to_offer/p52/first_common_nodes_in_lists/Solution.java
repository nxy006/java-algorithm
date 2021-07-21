package com.nxy006.project.algorithm.sword_to_offer.p52.first_common_nodes_in_lists;

import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 52：两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/52_FirstCommonNodesInLists
 *
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 执行用时：1 ms,    在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：41.1 MB, 在所有 Java 提交中击败了 67.27% 的用户
 * 2021/07/21 22:33
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null || nodeB != null) {
            if (nodeA == null) nodeA = headB;
            if (nodeB == null) nodeB = headA;

            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
