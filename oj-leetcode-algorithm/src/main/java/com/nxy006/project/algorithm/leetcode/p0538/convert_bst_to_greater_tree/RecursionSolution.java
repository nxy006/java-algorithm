package com.nxy006.project.algorithm.leetcode.p0538.convert_bst_to_greater_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 递归解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   42.2 MB , beats  93.38 % of java submissions.
 * 04/16/2022 17:17
 */
public class RecursionSolution {
    public TreeNode convertBST(TreeNode root) {
        convertGreater(root, 0);
        return root;
    }

    public int convertGreater(TreeNode root, int currentSum) {
        if (root == null) {
            return currentSum;
        }

        root.val += convertGreater(root.right, currentSum);
        return convertGreater(root.left, root.val);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(),
                "[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]",
                "[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        caseCheck(new RecursionSolution(), "[1,null,1]", "[0,null,1]");
    }

    private static void caseCheck(RecursionSolution solution, String expectedTree, String treeStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(expectedTree),
                solution.convertBST(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
