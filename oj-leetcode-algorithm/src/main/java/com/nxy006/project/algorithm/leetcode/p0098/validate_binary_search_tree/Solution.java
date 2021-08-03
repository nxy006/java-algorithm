package com.nxy006.project.algorithm.leetcode.p0098.validate_binary_search_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * TODO 待提交测试
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), true, "[2,1,3]");
        caseCheck(new Solution(), false, "[5,1,4,null,null,3,6]");
        // 自定义用例
        caseCheck(new Solution(), true, "[5,4,null,3,null,2,null,1]");
        caseCheck(new Solution(), false, "[5,4,null,3,null,2,null,6]");
        caseCheck(new Solution(), false, "[2,2,2]");
    }

    private static void caseCheck(Solution solution, boolean expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.isValidBST(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
