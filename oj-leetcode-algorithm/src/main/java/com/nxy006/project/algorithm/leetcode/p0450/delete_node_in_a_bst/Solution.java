package com.nxy006.project.algorithm.leetcode.p0450.delete_node_in_a_bst;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 常规解法
 * 1. 当删除的节点无右节点时：用左节点替代该节点即可
 * 2. 当删除的节点有右节点时：将右子树的最左节点（即最小的元素）替代该节点，并将待删除节点的左树移动为最左节点的子树
 *    （如果最左节点有右子树，用右子树替代最左节点的原位置）
 *
 * Runtime 1 ms  , beats  6.93 % of java submissions.
 * Memory  47 MB , beats  8.46 % of java submissions.
 * 11/22/2021 23:55
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = changeTree(root.right);
                node.left = root.left;
                return node;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    private TreeNode changeTree(TreeNode root) {
        if (root.left == null) {
            return root;
        }

        TreeNode curr = root, parent = null;
        while(curr.left != null) {
            parent = curr;
            curr = curr.left;
        }

        parent.left = curr.right;
        curr.right = root;
        return curr;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), new String[]{"[5,4,6,2,null,null,7]", "[5,2,6,null,4,null,7]"}, "[5,3,6,2,4,null,7]", 3);
        caseCheck(new Solution(), new String[]{"[5,3,6,2,4,null,7]"}, "[5,3,6,2,4,null,7]", 0);
        caseCheck(new Solution(), new String[]{"[]"}, "[]", 0);
        // 自定义用例 <解答未完整列举>
        caseCheck(new Solution(), new String[]{"[15,10,16,2,11,null,17,null,null,null,14]"},
                "[15,3,16,2,11,null,17,null,null,10,14]", 3);
        caseCheck(new Solution(), new String[]{"[15,10,16,2,14,null,17]"},
                "[15,3,16,2,14,null,17,null,null,10,null]", 3);
        caseCheck(new Solution(), new String[]{"[15,11,16,2,14,null,17]"},
                "[15,3,16,2,11,null,17,null,null,null,14]", 3);
        caseCheck(new Solution(), new String[]{"[15,5,16,2,11,null,17,null,null,8,14,null,null,6,9,null,null,null,7]"},
                "[15,3,16,2,11,null,17,null,null,8,14,null,null,6,9,null,null,5,7]", 3);
        caseCheck(new Solution(), new String[]{"[5,null,6,null,7]"},
                "[5,3,6,null,null,null,7]", 3);
        caseCheck(new Solution(), new String[]{"[5,1,6,null,null,null,7]"},
                "[5,3,6,1,null,null,7]", 3);
    }

    // TODO 正确的判断方法可能是新树是否是 BST 树且由非 key 值的其他元素构成
    private static void caseCheck(Solution solution, String[] treeStrExpected, String treeStr, int key) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToTreeNodeArr(treeStrExpected),
                solution.deleteNode(StructConvertUtils.convertToTreeNode(treeStr), key)
        );
    }
}
