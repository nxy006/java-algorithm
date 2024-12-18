package com.nxy006.project.algorithm.sword_to_offer.p08.next_node_in_binary_trees;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *       树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/08_NextNodeInBinaryTrees
 *
 * <p/>
 * 本题 LeetCode-CN 无原题，相似题目可参考：https://leetcode.cn/problems/P5rCT8
 */
public class Solution extends SolutionTemplate {

    @Override
    TreeNodeWithParent getNext(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            TreeNodeWithParent current = (TreeNodeWithParent) node.right;
            while(current.left != null) {
                current = (TreeNodeWithParent) current.left;
            }
            return current;
        }

        if (node.parent != null && node.parent.left == node) {
            return (TreeNodeWithParent) node.parent;
        }
        if (node.parent != null && node.parent.right == node) {
            TreeNodeWithParent current = (TreeNodeWithParent) node.parent;
            while(current.parent != null && current.parent.left == current) {
                current = (TreeNodeWithParent) current.parent;
            }
            return current;
        }
        return null;
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
