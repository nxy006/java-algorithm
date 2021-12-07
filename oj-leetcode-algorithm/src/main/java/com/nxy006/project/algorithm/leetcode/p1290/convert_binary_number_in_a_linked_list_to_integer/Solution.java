package com.nxy006.project.algorithm.leetcode.p1290.convert_binary_number_in_a_linked_list_to_integer;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;

/**
 * 位运算解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats 100.00 % of java submissions.
 * Memory   36.2 MB , beats  96.50 % of java submissions.
 * 12/07/2021 23:52
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        int ret = 0;
        while(head != null) {
            ret <<= 1;
            ret += head.val;

            head = head.next;
        }
        return ret;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 5, "[1,0,1]");
        caseCheck(new Solution(), 0, "[0]");
        caseCheck(new Solution(), 1, "[1]");
        caseCheck(new Solution(), 18880, "[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]");
        caseCheck(new Solution(), 0, "[0,0]");
    }

    private static void caseCheck(Solution solution, int expected, String listStr) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.getDecimalValue(StructConvertUtils.convertToListNode(listStr)));
    }
}
