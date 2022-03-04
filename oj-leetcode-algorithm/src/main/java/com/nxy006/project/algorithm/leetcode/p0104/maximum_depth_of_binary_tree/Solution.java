package com.nxy006.project.algorithm.leetcode.p0104.maximum_depth_of_binary_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 深度优先算法
 * 时间复杂度：O(n)，空间复杂度：O(depth)
 *
 * Runtime 3 ms  , beats 100.00 % of java submissions.
 * Memory  42 MB , beats  59.70 % of java submissions.
 * 03/05/2022 01:48
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 3, "[3,9,20,null,null,15,7]");
        caseCheck(new Solution(), 2, "[1,null,2]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.maxDepth(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
