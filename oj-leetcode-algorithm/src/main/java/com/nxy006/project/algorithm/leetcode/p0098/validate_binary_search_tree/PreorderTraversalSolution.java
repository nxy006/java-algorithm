package com.nxy006.project.algorithm.leetcode.p0098.validate_binary_search_tree;

import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 中序遍历解法
 *
 * 根据二叉搜索树的性质，其中序遍历的结果一定是升序的，因此可以中序遍历判断是否递增。
 * 解法省略。
 *
 */
public class PreorderTraversalSolution extends SolutionTemplate {
    @Override
    boolean isValidBST(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        processCaseTest(new PreorderTraversalSolution());
    }
}

