package com.nxy006.project.algorithm.leetcode.p0404.sum_of_left_leaves;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 深度优先遍历
 * 时间复杂度：O(n)，空间复杂度：O(depth)
 *
 * Runtime 0 ms    , beats 100.00 % of java submissions.
 * Memory  37.2 MB , beats  43.63 % of java submissions.
 * 11/04/2021 22:57
 */
public class DfsSolution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }

        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DfsSolution(), 24, "[3,9,20,null,null,15,7]");
        caseCheck(new DfsSolution(), 0, "[1]");
        // 自定义用例
        caseCheck(new DfsSolution(), 16, "[3,9,20,1,null,15,7,null,null]");
    }

    private static void caseCheck(DfsSolution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.sumOfLeftLeaves(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
