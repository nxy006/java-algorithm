package com.nxy006.project.algorithm.leetcode.p0938.range_sum_of_bst;

import com.nxy006.project.algorithm.leetcode.p0337.house_robber_iii.Solution;
import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 深度优先遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  1 ms    , beats 100.00 % of java submissions.
 * Memory   47.1 MB , beats  88.01 % of java submissions.
 * 12/14/2021 23:46
 */
public class DFSSolution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DFSSolution(), 32, "[10,5,15,3,7,null,18]", 7, 15);
        caseCheck(new DFSSolution(), 23, "[10,5,15,3,7,13,18,1,null,6]", 6, 10);
    }

    private static void caseCheck(DFSSolution solution, int expected, String treeStr, int low, int high) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.rangeSumBST(StructConvertUtils.convertToTreeNode(treeStr), low, high));
    }
}
