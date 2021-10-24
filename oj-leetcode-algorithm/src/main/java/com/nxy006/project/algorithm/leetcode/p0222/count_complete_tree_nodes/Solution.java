package com.nxy006.project.algorithm.leetcode.p0222.count_complete_tree_nodes;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;


/**
 * 常规解法
 * 完全二叉树的深度 = (2^满二叉树深度-1)+多余叶子节点数量，因而只需计算最大深度及最大深度的节点数即可
 * 为避免遍历全量节点，可利用完全二叉树 “左树深度必然大于等于右树深度” 的特点，如果左树高度偏低则右树无需检查
 * 时间复杂度：< O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   47.2 MB , beats  17.46 % of java submissions.
 * 10/24/2021 23:37
 */
public class Solution {
    int maxDepth = -1, maxCount = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countNodes(root, 1);
        return (int) Math.pow(2, maxDepth-1) - 1 + maxCount;
    }

    // 方法的返回值是子树的最大深度
    private int countNodes(TreeNode node, int depth) {
        if (node == null) {
            return depth-1;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            maxCount = 1;
        } else if (depth == maxDepth){
            maxCount++;
        }

        // 优化点：因为左树深度必然大于等于右树深度，如果左树的深度都没有达到最大深度，右树便无需检查深度
        int leftDepth;
        if ((leftDepth = countNodes(node.left, depth+1)) == maxDepth) {
            countNodes(node.right, depth+1);
        }
        return leftDepth;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 6, "[1,2,3,4,5,6]");
        caseCheck(new Solution(), 0, "[]");
        caseCheck(new Solution(), 1, "[1]");
        // 官方用例
        caseCheck(new Solution(), 7, "[1,2,3,4,5,6,7]");
        caseCheck(new Solution(), 8, "[1,2,3,4,5,6,7,8]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.countNodes(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
