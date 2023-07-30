package com.nxy006.project.algorithm.sword_to_offer.p06.rrint_list_in_reversed_order;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题 6：从尾到头打印链表
 * <p>
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/blob/master/06_PrintListInReversedOrder">gitHub</a><br/>
 *
 * <blockquote><pre>
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre></blockquote>
 * <p/>
 */
public class SolutionTemplate {
    public int[] reversePrint(ListNode head) {
        throw new RuntimeException("未实现的方法");
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new SolutionTemplate());
    }

    public static void processCaseTest(SolutionTemplate solution) {
        // Leetcode-CN 题目示例
        caseCheck(solution,"[2,3,1]", "[1,3,2]");
        // 书籍用例（省略用例5. 传入 null）
        caseCheck(solution,"[5,4,3,2,1]", "[1,2,3,4,5]");       // 1. 1->2->3->4->5
        caseCheck(solution,"[1]", "[1]");                       // 2. 只有一个结点的链表: 1
        caseCheck(solution,"[]", null);                         // 3. 空链表
    }

    public static void caseCheck(SolutionTemplate solution, String expected, String listStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntArray(expected),
                solution.reversePrint(StructConvertUtils.convertToListNode(listStr)));
    }
}
