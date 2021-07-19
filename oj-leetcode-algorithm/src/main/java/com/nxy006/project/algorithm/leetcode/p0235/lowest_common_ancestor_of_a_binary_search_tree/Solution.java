package com.nxy006.project.algorithm.leetcode.p0235.lowest_common_ancestor_of_a_binary_search_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 *
 * Runtime  3 ms    , beats 100.00 % of java submissions.
 * Memory   39.8 MB , beats  69.38 % of java submissions.
 * 07/19/2021 23:09
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val <= root.val && root.val <= q.val || p.val >= root.val && root.val >= q.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 6,"[6,2,8,0,4,7,9,null,null,3,5]", 2, 8);
        caseCheck(new Solution(), 2,"[6,2,8,0,4,7,9,null,null,3,5]", 2, 4);
    }

    private static void caseCheck(Solution solution, int expected, String numsStr, int p, int q) {
        CaseAssertUtils.assertEquals(new TreeNode(expected),
                solution.lowestCommonAncestor(StructConvertUtils.convertToTreeNode(numsStr), new TreeNode(p), new TreeNode(q)));
    }
}
