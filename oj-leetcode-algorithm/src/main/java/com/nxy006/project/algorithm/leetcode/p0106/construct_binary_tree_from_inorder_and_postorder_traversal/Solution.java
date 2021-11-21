package com.nxy006.project.algorithm.leetcode.p0106.construct_binary_tree_from_inorder_and_postorder_traversal;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 * 对任何二叉树（或其子树），其中序和后续遍历结果均满足：
 *  - 中序遍历：[左子树 | 根节点 | 右子树]
 *  - 后序遍历：[左子树 | 右子树 | 根节点]
 * 因而，可根据后序遍历的最末元素将中序遍历结果的结果进行划分，从而得到左右子树范围，根据子树长度后序遍历则也可以划分
 *
 * Runtime 3 ms    , beats 52.79 % of java submissions.
 * Memory  38.8 MB , beats 84.93 % of java submissions.
 * 11/21/2021 23:20
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int start, int end, int[] postorder, int index) {
        if (start > end || index < 0) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[index]);
        int current = start;
        for(int i = start; i <= end; i++) {
            if (inorder[i] == postorder[index]) {
                current = i;
                break;
            }
        }

        node.left = buildTree(inorder, start, current-1, postorder, index-(end-current+1));
        node.right = buildTree(inorder, current+1, end, postorder, index-1);
        return node;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[3,9,20,null,null,15,7]", "[9,3,15,20,7]", "[9,15,7,20,3]");
        caseCheck(new Solution(), "[-1]", "[-1]", "[-1]");
    }

    private static void caseCheck(Solution solution, String treeStrExpected, String inorderStr, String postorder) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(treeStrExpected),
                solution.buildTree(
                        StructConvertUtils.convertToIntArray(inorderStr),
                        StructConvertUtils.convertToIntArray(postorder))
        );
    }
}
