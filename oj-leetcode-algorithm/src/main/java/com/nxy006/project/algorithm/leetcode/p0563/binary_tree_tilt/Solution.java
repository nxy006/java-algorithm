package com.nxy006.project.algorithm.leetcode.p0563.binary_tree_tilt;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  1 ms  , beats 100.00 % of java submissions.
 * Memory   39 MB , beats  83.37 % of java submissions.
 * 12/08/2021 22:54
 */
public class Solution {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        rebuild(root);
        return sum;
    }

    public int rebuild(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = rebuild(root.left), right = rebuild(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 1, "[1,2,3]");
        caseCheck(new Solution(), 15, "[4,2,9,3,5,null,7]");
        caseCheck(new Solution(), 9, "[21,7,14,1,1,2,2,3,3]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.findTilt(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
