package com.nxy006.project.algorithm.leetcode.p0101.symmetric_tree;

import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   40.35 MB, beats 74.19 % of java submissions.
 * 10/23/2021 01:01
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
