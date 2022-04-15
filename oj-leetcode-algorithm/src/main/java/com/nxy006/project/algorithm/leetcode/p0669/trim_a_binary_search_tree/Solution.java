package com.nxy006.project.algorithm.leetcode.p0669.trim_a_binary_search_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   41.9 MB , beats  87.65 % of java submissions.
 * 04/15/2022 23:22
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val > high) {
            return root.left;
        } else if (root.val < low) {
            return root.right;
        } else {
            return root;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,null,2]", "[1,0,2]", 1, 2);
        caseCheck(new Solution(), "[3,2,null,1]", "[3,0,4,null,2,null,null,1]", 1, 3);
        // 自定义用例
        caseCheck(new Solution(), "[3,0,null,null,2,1]", "[3,0,4,null,2,null,null,1]", 0, 3);
    }

    private static void caseCheck(Solution solution, String expectedTree, String treeStr, int low, int high) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(expectedTree),
                solution.trimBST(StructConvertUtils.convertToTreeNode(treeStr), low, high));
    }
}
