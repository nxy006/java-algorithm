package com.nxy006.project.algorithm.leetcode.p0094.binary_tree_inorder_traversal;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   37.5 MB , beats  34.81 % of java submissions.
 * 08/03/2021 22:52
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    private void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return ;

        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), "[1,3,2]", "[1,null,2,3]");
        caseCheck(new Solution(), "[]", "[]");
        caseCheck(new Solution(), "[1]", "[1]");
        caseCheck(new Solution(), "[1,2]", "[2,1]");
        caseCheck(new Solution(), "[1,2]", "[1,null,2]");
    }

    private static void caseCheck(Solution solution, String expected, String treeStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntegerList(expected), solution.inorderTraversal(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
