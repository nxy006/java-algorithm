package com.nxy006.project.algorithm.leetcode.p0230.kth_smallest_element_in_a_bst;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 递归解法
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   42 MB , beats  91.65 % of java submissions.
 * 04/18/2022 12:19
 */
public class RecursionSolution {
    private int cnt = 1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        int n = kthSmallest(root.left, k);
        if (n != -1) {
            return n;
        }
        if (cnt++ == k) {
            return root.val;
        }
        n = kthSmallest(root.right, k);
        if (n != -1) {
            return n;
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), 1, "[3,1,4,null,2]",1);
        caseCheck(new RecursionSolution(), 3, "[5,3,6,2,4,null,null,1]",3);
        // 自定义用例
        caseCheck(new RecursionSolution(), 4, "[3,1,4,null,2]",4);
        caseCheck(new RecursionSolution(), 3, "[3,1,4,null,2]",3);
    }

    private static void caseCheck(RecursionSolution solution, int expected, String treeStr, int k) {
        CaseAssertUtils.assertEquals(expected, solution.kthSmallest(StructConvertUtils.convertToTreeNode(treeStr), k));
    }
}
