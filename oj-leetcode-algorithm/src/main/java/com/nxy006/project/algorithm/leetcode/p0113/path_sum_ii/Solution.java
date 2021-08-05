package com.nxy006.project.algorithm.leetcode.p0113.path_sum_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 *  深度优先遍历
 *  时间复杂度：O(n^2)，空间复杂度：O(n)
 *
 *  Runtime  1 ms    , beats 99.91 % of java submissions.
 *  Memory   39.4 MB , beats 65.62 % of java submissions.
 *  08/05/2021 01:34
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        process(root, targetSum, 0, res, new ArrayList<>());
        return res;
    }

    public void process(TreeNode root, int targetSum, int currentSum,
                        List<List<Integer>> res, List<Integer> list) {
        if (root == null) return ;

        list.add(root.val);
        currentSum += root.val;
        if (root.left == null && root.right == null && currentSum == targetSum) {
            res.add(new ArrayList(list));
        }

        process(root.left, targetSum, currentSum, res, list);
        process(root.right, targetSum, currentSum, res, list);
        list.remove(list.size()-1);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[5,4,11,2],[5,8,4,5]]", "[5,4,8,11,null,13,4,7,2,null,null,5,1]", 22);
        caseCheck(new Solution(), "[]", "[1,2,3]", 5);
        caseCheck(new Solution(), "[]", "[1,2]", 0);
        // 自定义用例
        caseCheck(new Solution(), "[[1]]", "[1]", 1);
    }

    private static void caseCheck(Solution solution, String expectedNestedList, String root, int targetSum) {
        CaseAssertUtils.assertEqualsIgnoreOrder(
                StructConvertUtils.convertToIntegerNestedList(expectedNestedList),
                solution.pathSum(StructConvertUtils.convertToTreeNode(root), targetSum));
    }
}
