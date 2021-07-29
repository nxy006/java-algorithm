package com.nxy006.project.algorithm.sword_to_offer.p06.rrint_list_in_reversed_order;

import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 *
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题 6：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/06_PrintListInReversedOrder
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了  77.68 % 的用户
 * 2021/07/29 23:24
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};

        ListNode prevNode = head, node = head.next;
        head.next = null;
        int cnt = 1;
        while(node != null) {
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
            cnt++;
        }

        int[] res = new int[cnt];
        int i = 0;
        node = prevNode;
        while(node != null) {
            res[i++] = node.val;
            node = node.next;
        }
        return res;
    }
}
