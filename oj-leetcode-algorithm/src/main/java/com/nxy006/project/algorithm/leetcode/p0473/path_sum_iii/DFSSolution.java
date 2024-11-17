package com.nxy006.project.algorithm.leetcode.p0473.path_sum_iii;

import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  58 ms   , beats 5.03% of java submissions.
 * Memory   44.72 MB, beats 8.70 % of java submissions.
 * 16/11/2024 14:01
 */
public class DFSSolution extends SolutionTemplate {
    public int pathSum(TreeNode root, int targetSum) {
        return treePath(root, targetSum, new ArrayList<>());
    }

    private int treePath(TreeNode node, int targetSum, List<Long> sums) {
        if (node == null) {
            return 0;
        }

        sums.add(0l);
        int result = 0;
        for(int i = 0; i < sums.size(); i++) {
            long sum = sums.get(i);
            if ((sum = sum + node.val) == targetSum) {
                result++;
            }
            sums.set(i, sum);
        }

        result += treePath(node.left, targetSum, sums);
        result += treePath(node.right, targetSum, sums);

        for(int i = 0; i < sums.size(); i++) {
            sums.set(i, sums.get(i) - node.val);
        }
        sums.remove(sums.size()-1);
        return result;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //
    public static void main(String[] args) {
        processCaseTest(new DFSSolution());
    }
}
