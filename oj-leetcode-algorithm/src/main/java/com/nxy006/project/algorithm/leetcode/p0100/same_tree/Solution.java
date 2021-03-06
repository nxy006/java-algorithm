package com.nxy006.project.algorithm.leetcode.p0100.same_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 递归解法
 * 时间复杂度：O(n)，空间复杂度：O(log_n)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   36.5 MB , beats  35.99 % of java submissions.
 * 08/03/2021 23:07
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), true, "[1,2,3]", "[1,2,3]");
        caseCheck(new Solution(), false, "[1,2]", "[1,null,2]");
        caseCheck(new Solution(), false, "[1,2,1]", "[1,1,2]");
    }

    private static void caseCheck(Solution solution, boolean expected, String root1, String root2) {
        CaseAssertUtils.assertEquals(expected, solution.isSameTree(StructConvertUtils.convertToTreeNode(root1), StructConvertUtils.convertToTreeNode(root2)));
    }
}
