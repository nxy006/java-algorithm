package com.nxy006.project.algorithm.sword_to_offer.p07.construct_binary_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.ListNode;
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
 */
public abstract class SolutionTemplate {
    public abstract TreeNode deduceTree(int[] preorder, int[] inorder);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // Leetcode-CN 题目示例
        caseCheck(solution,"[3,9,20,null,null,15,7]", "[3,9,20,15,7]", "[9,3,15,20,7]");
        // 书籍用例（省略用例 6：输入空指针，用例 7：输入的两个序列不匹配）
        caseCheck(solution,"[1,2,3,4,null,5,6,null,7,null,null,8,null]",
                "[1,2,4,7,3,5,6,8]", "[4,7,2,1,5,3,8,6]");  // 普通二叉树
        caseCheck(solution,"[1,2,null,3,null,4,null,5,null]",
                "[1,2,3,4,5]", "[5,4,3,2,1]");  // 所有结点都没有右子结点
        caseCheck(solution,"[1,null,2,null,3,null,4,null,5]",
                "[1,2,3,4,5]", "[1,2,3,4,5]");  // 所有结点都没有左子结点
        caseCheck(solution,"[1]", "[1]", "[1]");  // 树中只有一个结点
        caseCheck(solution,"[1,2,3,4,5,6,7]", "[1,2,4,5,3,6,7]", "[4,2,5,1,6,3,7]");   // 完全二叉树
    }

    public static void caseCheck(SolutionTemplate solution, String expected, String preorder, String inorder ) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(expected),
                solution.deduceTree(
                        StructConvertUtils.convertToIntArray(preorder),
                        StructConvertUtils.convertToIntArray(inorder)));
    }
}
