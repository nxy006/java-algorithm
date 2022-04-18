package com.nxy006.project.algorithm.leetcode.p0897.increasing_order_search_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 递归解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.8 MB , beats  92.52 % of java submissions.
 * 04/18/2022 21:40
 */
public class RecursionSolution {
    TreeNode ans = new TreeNode(), curNode = ans;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        increasingBST(root.left);
        curNode.right = new TreeNode(root.val);
        curNode = curNode.right;
        increasingBST(root.right);
        return ans.right;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(),
                "[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]",
                "[5,3,6,2,4,null,8,1,null,null,null,7,9]");
        caseCheck(new RecursionSolution(), "[1,null,5,null,7]", "[5,1,7]");
        // 自定义用例
        caseCheck(new RecursionSolution(), "[1]", "[1]");
    }

    private static void caseCheck(RecursionSolution solution, String expectedStr, String treeStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(expectedStr),
                solution.increasingBST(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
