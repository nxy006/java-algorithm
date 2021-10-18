package com.nxy006.project.algorithm.leetcode.p0993.cousins_in_binary_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 深度优先遍历
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime 0 ms    , beats 100.00 % of java submissions.
 * Memory  38.9 MB , beats  18.71 % of java submissions.
 * 10/18/2021 23:42
 */
public class DfsSolution {
    private int depthX = 0, depthY = 0, ParentX = 0, ParentY = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, new TreeNode(0), x, y, 0);
        return depthX == depthY && ParentX != ParentY;
    }

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int d) {
        if (root == null) return ;
        if (root.val == x) {
            depthX = d;
            ParentX = parent.val;
        }
        if (root.val == y) {
            depthY = d;
            ParentY = parent.val;
        }
        dfs(root.left, root, x, y, d+1);
        dfs(root.right, root, x, y, d+1);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DfsSolution(), false, "[1,2,3,4]", 4, 3);
        caseCheck(new DfsSolution(), true, "[1,2,3,null,4,null,5]", 5, 4);
        caseCheck(new DfsSolution(), false, "[1,2,3,null,4]", 2, 3);
    }

    private static void caseCheck(DfsSolution solution, boolean expected, String treeStr, int x, int y) {
        CaseAssertUtils.assertEquals(expected, solution.isCousins(StructConvertUtils.convertToTreeNode(treeStr), x, y));
    }
}
