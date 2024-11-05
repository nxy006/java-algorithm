package com.nxy006.project.algorithm.sword_to_offer.p08.next_node_in_binary_trees;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.*;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *       树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/08_NextNodeInBinaryTrees
 */
public abstract class SolutionTemplate {
    abstract TreeNodeWithParent getNext(TreeNodeWithParent node);

    // ---------------------------------------------------------- 结构定义 ----------------------------------------------------------- //
    static class TreeNodeWithParent extends TreeNode {
        public TreeNode parent;

        public TreeNodeWithParent() {
        }

        public TreeNodeWithParent(int x) {
            super(x);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            return this.val == ((TreeNodeWithParent) o).val;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // Leetcode-CN 题目示例
        caseCheck(solution, "[2,1,3]", 2, 1);
        caseCheck(solution, "[5,3,6,2,4,null,null,1]", null, 6);
        // 书籍用例
        //          8
        //       6     10
        //     5  7   9  11
        caseCheck(solution, "[8,6,10,5,7,9,11]", 9, 8);
        caseCheck(solution, "[8,6,10,5,7,9,11]", 7, 6);
        caseCheck(solution, "[8,6,10,5,7,9,11]", 11, 10);
        caseCheck(solution, "[8,6,10,5,7,9,11]", 6, 5);
        caseCheck(solution, "[8,6,10,5,7,9,11]", 8, 7);
        caseCheck(solution, "[8,6,10,5,7,9,11]", 10, 9);
        caseCheck(solution, "[8,6,10,5,7,9,11]", null, 11);
        //            5
        //          4
        //        3
        //      2
        caseCheck(solution, "[5,4,null,3,null,2,null]", null, 5);
        caseCheck(solution, "[5,4,null,3,null,2,null]", 5, 4);
        caseCheck(solution, "[5,4,null,3,null,2,null]", 4, 3);
        caseCheck(solution, "[5,4,null,3,null,2,null]", 3, 2);
        //        2
        //         3
        //          4
        //           5
        caseCheck(solution, "[2,null,3,null,4,null,5]", null, 5);
        caseCheck(solution, "[2,null,3,null,4,null,5]", 5, 4);
        caseCheck(solution, "[2,null,3,null,4,null,5]", 4, 3);
        caseCheck(solution, "[2,null,3,null,4,null,5]", 3, 2);
        //     5
        caseCheck(solution, "[5]", null, 5);
    }

    public static void caseCheck(SolutionTemplate solution, String s, Integer expected, int nodeVal) {
        TreeNodeWithParent root = convertToTreeNodeWithHead(s);
        Map<Integer, TreeNodeWithParent> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            map.put(node.val, (TreeNodeWithParent) node);

            if (node.left != null) { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right); }
        }

        CaseAssertUtils.assertEquals(
                expected == null ? null : new TreeNodeWithParent(expected),
                solution.getNext(map.get(nodeVal)));
    }

    // ---------------------------------------------------------- 辅助方法 ----------------------------------------------------------- //

    private static TreeNodeWithParent convertToTreeNodeWithHead(String s) {
        TreeNode root = StructConvertUtils.convertToTreeNode(s);
        return convertToTreeNodeWithHead(root, null);
    }

    private static TreeNodeWithParent convertToTreeNodeWithHead(TreeNode node, TreeNode parentNode) {
        if (node == null) {
            return null;
        }

        TreeNodeWithParent newNode = new TreeNodeWithParent();
        newNode.val = node.val;
        newNode.left = convertToTreeNodeWithHead(node.left, newNode);
        newNode.right = convertToTreeNodeWithHead(node.right, newNode);
        newNode.parent = parentNode;
        return newNode;
    }
}
