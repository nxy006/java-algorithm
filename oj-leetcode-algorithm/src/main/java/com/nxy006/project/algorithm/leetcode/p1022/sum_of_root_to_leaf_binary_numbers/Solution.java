package com.nxy006.project.algorithm.leetcode.p1022.sum_of_root_to_leaf_binary_numbers;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法：深度优先
 * 时间复杂度：O(n)，空间复杂度：O(k)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   39.3 MB , beats  25.98 % of java submissions.
 * 01/11/2022 23:04
 */
public class Solution {
    private int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return res;
    }

    public void sumRootToLeaf(TreeNode node, int num) {
        if (node == null) {
            return ;
        }

        num <<= 1;
        num += node.val;

        if (node.left == null && node.right == null) {
            res += num;
        } else {
            sumRootToLeaf(node.left, num);
            sumRootToLeaf(node.right, num);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), 22, "[1,0,1,0,1,0,1]");
        caseCheck(new Solution(), 0, "[0]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.sumRootToLeaf(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
