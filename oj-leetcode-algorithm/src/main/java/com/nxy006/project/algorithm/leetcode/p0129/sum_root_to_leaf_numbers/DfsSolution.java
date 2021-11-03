package com.nxy006.project.algorithm.leetcode.p0129.sum_root_to_leaf_numbers;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 深度优先遍历
 * 时间复杂度：O(n)，空间复杂度：O(d)，n 为二叉树节点数，d 为二叉树最大深度
 *
 * Runtime 0 ms    , beats 100.00 % of java submissions.
 * Memory  36.9 MB , beats  47.67 % of java submissions.
 * 11/04/2021 00:01
 */
public class DfsSolution {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            sumNumbers(root, new StringBuilder());
        }
        return res;
    }

    public void sumNumbers(TreeNode node, StringBuilder sb) {
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            res += Integer.valueOf(sb.toString());
        } else {
            if (node.left != null) {
                sumNumbers(node.left, sb);
            }
            if (node.right != null) {
                sumNumbers(node.right, sb);
            }
        }

        sb.setLength(sb.length()-1);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DfsSolution(), 25, "[1,2,3]");
        caseCheck(new DfsSolution(), 1026, "[4,9,0,5,1]");
    }

    private static void caseCheck(DfsSolution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.sumNumbers(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
