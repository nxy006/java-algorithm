package com.nxy006.project.algorithm.leetcode.p0098.validate_binary_search_tree;

import com.nxy006.project.alogtithm.utils.struct.TreeNode;

/**
 * 模拟
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * 题目本身很简单（只关心数据范围，不关心是否平衡），主要在卡 Integer 范围。比如当前节点已经是最小值，怎么和左侧元素比较大小。
 * 此解法用的是 long 数据类型处理，还可以考虑传递开区间范围（但要单独兼容最大最小值）、或者直接对最大最小值做特殊判断
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   43.35 MB, beats  58.99 % of java submissions.
 * 12/11/2024 13:55
 */
public class Solution extends SolutionTemplate {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long start, long end) {
        if (root == null) {
            return true;
        }

        return root.val >= start && root.val <= end &&
                isValidBST(root.left, start, ((long)root.val)-1) &&
                isValidBST(root.right, ((long)root.val)+1, end);
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
