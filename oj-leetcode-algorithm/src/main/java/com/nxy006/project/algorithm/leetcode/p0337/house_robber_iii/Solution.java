package com.nxy006.project.algorithm.leetcode.p0337.house_robber_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;
import javafx.util.Pair;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(h)，h 是二叉树的高度
 *
 * Runtime  1 ms    , beats 58.80 % of java submissions.
 * Memory   38.8 MB , beats 42.98 % of java submissions.
 * 12/05/2021 23:02
 */
public class Solution {
    public int rob(TreeNode root) {
        Pair<Integer, Integer> res = robx(root);
        return Integer.max(res.getKey(), res.getValue());
    }

    public Pair<Integer, Integer> robx(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> leftRes = robx(node.left);
        Pair<Integer, Integer> rightRes = robx(node.right);

        // 返回值：偷盗当前节点后的最大收益，不偷盗当前节点的最大收益
        return new Pair<>(
                node.val + leftRes.getValue() + rightRes.getValue(),
                Integer.max(leftRes.getKey(), leftRes.getValue()) + Integer.max(rightRes.getKey(), rightRes.getValue())
        );
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 7, "[3,2,3,null,3,null,1]");
        caseCheck(new Solution(), 9, "[3,4,5,1,3,null,1]");
    }

    private static void caseCheck(Solution solution, int expected, String treeStr) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.rob(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
