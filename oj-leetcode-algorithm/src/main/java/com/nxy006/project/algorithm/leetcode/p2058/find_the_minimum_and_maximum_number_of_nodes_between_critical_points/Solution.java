package com.nxy006.project.algorithm.leetcode.p2058.find_the_minimum_and_maximum_number_of_nodes_between_critical_points;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;


public class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minCiritcalIndex = -1, maxCiritcalIndex = -1, minDisance = -1, maxDisance = -1;
        if (head == null) {
            return new int[]{-1, -1};
        }

        int prevValue = head.val, i = 0;
        ListNode node = head.next;
        while(node != null) {
            if (node.next == null) {
                break;
            }

            if (node.val > prevValue && node.val > node.next.val || node.val < prevValue && node.val < node.next.val) {
                if (minCiritcalIndex == -1) {
                    minCiritcalIndex = i;
                    maxCiritcalIndex = i;
                } else {
                    minDisance = minDisance == -1 ? i - maxCiritcalIndex : (Integer.min(minDisance, i - maxCiritcalIndex));
                    maxDisance = i - minCiritcalIndex;
                    maxCiritcalIndex = i;
                }
            }

            prevValue = node.val;
            node = node.next;
            i++;
        }
        return new int[]{minDisance, maxDisance};
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[-1,-1]", "[3,1]");
        caseCheck(new Solution(), "[1,3]", "[5,3,1,2,5,1,2]");
        caseCheck(new Solution(), "[3,3]", "[1,3,2,2,3,2,2,2,7]");
        caseCheck(new Solution(), "[-1,-1]", "[2,3,3,2]");
    }

    private static void caseCheck(Solution solution, String arrExpected, String listStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntArray(arrExpected),
                solution.nodesBetweenCriticalPoints(StructConvertUtils.convertToListNode(listStr)));
    }
}
