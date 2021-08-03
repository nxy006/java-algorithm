package com.nxy006.project.algorithm.leetcode.p0061.rotate_list;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   38.5 MB , beats  50.00 % of java submissions.
 * 08/03/2021 22:31
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;

        // 最小化 k 取值
        int cnt = lengthOfListNode(head);
        k = k % cnt;
        if (k == 0) {
            return head;
        }

        // 处理链表
        ListNode lNode = head, rNode = head;
        while(k-- > 0) {
            rNode = rNode.next;
        }
        while(rNode.next != null) {
            lNode = lNode.next;
            rNode = rNode.next;
        }

        ListNode root = lNode.next;
        lNode.next = null;
        rNode.next = head;
        return root;
    }

    private int lengthOfListNode(ListNode head) {
        int cnt = 0;
        ListNode node = head;
        while(node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[4,5,1,2,3]", "[1,2,3,4,5]", 2);
        caseCheck(new Solution(), "[2,0,1]", "[0,1,2]", 4);
        // 自定义用例
        caseCheck(new Solution(), "[1,2,3,4,5]", "[1,2,3,4,5]", 0);
        caseCheck(new Solution(), "[4,5,1,2,3]", "[1,2,3,4,5]", 102);
        caseCheck(new Solution(), "[1,2,3,4,5]", "[1,2,3,4,5]", 5);
        caseCheck(new Solution(), "[2,3,4,5,1]", "[1,2,3,4,5]", 4);
    }

    private static void caseCheck(Solution solution, String expected, String listStr, int k) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToListNode(expected),
                solution.rotateRight(StructConvertUtils.convertToListNode(listStr), k));
    }
}
