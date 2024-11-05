package com.nxy006.project.algorithm.sword_to_offer.p08.next_node_in_binary_trees;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *       树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/08_NextNodeInBinaryTrees
 */
public class OfficialSolution extends SolutionTemplate{
    @Override
    TreeNodeWithParent getNext(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        TreeNodeWithParent nextNode = null;
        if (node.right != null) {
            TreeNodeWithParent rightNode = (TreeNodeWithParent) node.right;
            while(rightNode.left != null) {
                rightNode = (TreeNodeWithParent) rightNode.left;
            }
            nextNode = rightNode;
        } else if (node.parent != null) {
            TreeNodeWithParent currentNode = node;
            TreeNodeWithParent parentNode = (TreeNodeWithParent) node.parent;
            while(parentNode != null && currentNode == parentNode.right) {
                currentNode = parentNode;
                parentNode = (TreeNodeWithParent) parentNode.parent;
            }
            nextNode = parentNode;
        }
        return nextNode;
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
