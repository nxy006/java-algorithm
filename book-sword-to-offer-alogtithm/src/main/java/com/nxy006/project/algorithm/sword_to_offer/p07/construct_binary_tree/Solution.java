package com.nxy006.project.algorithm.sword_to_offer.p07.construct_binary_tree;

import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题7：重建二叉树
 * <p>
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 *      入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 *      2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 *      图2.6所示的二叉树并输出它的头结点。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/blob/master/07_ConstructBinaryTree">gitHub</a><br/>
 *
 * <blockquote>
 * Definition for a binary tree node.
 * <pre>
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
 * </pre></blockquote>
 * <p/>
 *
 * <hr/>
 * <p>
 * LeetCode-CN 解答：<br/>
 * - Link：<a href="https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/">leetcode-cn</a><br/>
 * - 执行用时：3 ms,     在所有 Java 提交中击败了 44.00 % 的用户<br/>
 * - 内存消耗：42.51 MB, 在所有 Java 提交中击败了 99.53 % 的用户<br/>
 * - 2024.10.28 16:54
 * <p/>
 */
public class Solution extends SolutionTemplate {
    @Override
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        return deduceTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode deduceTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }

        int val = preorder[l1], mid = -1;
        for(int i = l2; i <= r2; i++) {
            if (inorder[i] == val) {
                mid = i;
                break;
            }
        }

        TreeNode result = new TreeNode(val);
        result.left = deduceTree(preorder, l1+1, l1+(mid-l2), inorder, l2, mid-1);
        result.right = deduceTree(preorder, l1+1+(mid-l2), r1, inorder, mid+1, r2);
        return result;
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
