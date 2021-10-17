package com.nxy006.project.algorithm.leetcode.p0437.path_sum_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.*;

/**
 * 前缀和解法
 * 记录每个节点距离根节点的路径和，并找到符合差值的且具有父子关系的路径和节点
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime 28 ms   , beats 11.84 % of java submissions.
 * Memory  39.2 MB , beats 43.75 % of java submissions.
 * 10/17/2021 23:41
 */
public class PrefixSumSolution {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0, new HashMap<>(), new HashSet<>());
    }

    /**
     * 计算该节点及其子节点为末尾的路径中满足该路径和的数量
     *
     * @param node 当前节点
     * @param targetSum 目标和
     * @param sum 从根节点开始的已有和
     * @param sumNodeMap 映射：从根节点开始的和 -> 对应的所有节点
     * @param parents 当前节点的父节点集合
     * @return 路径和数量
     */
    public int pathSum(TreeNode node, int targetSum, int sum,
                       Map<Integer, List<TreeNode>> sumNodeMap, Set<TreeNode> parents) {
        if (node == null) {
            return 0;
        }

        // 根节点到当前节点计数和
        sum += node.val;

        // 统计以 node 为末节点，且距离当前为 targetSum 的父节点数量
        int count = (sum == targetSum) ? 1 : 0;
        List<TreeNode> targetNodes = sumNodeMap.getOrDefault(sum - targetSum, new ArrayList<>());
        for(TreeNode targetNode : targetNodes) {
            if (parents.contains(targetNode)) {
                count++;
            }
        }

        // 将当前节点的计数记录到 Map
        List<TreeNode> currentNodes = sumNodeMap.getOrDefault(sum, new ArrayList<>());
        currentNodes.add(node);
        sumNodeMap.put(sum, currentNodes);

        // 记录当前节点到父节点并统计子节点的路径数量
        parents.add(node);
        count += pathSum(node.left, targetSum, sum, sumNodeMap, parents) + pathSum(node.right, targetSum, sum, sumNodeMap, parents);
        parents.remove(node);
        return count;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new PrefixSumSolution(), 3, "[10,5,-3,3,2,null,11,3,-2,null,1]", 8);
        caseCheck(new PrefixSumSolution(), 3, "[5,4,8,11,null,13,4,7,2,null,null,5,1]", 22);
        // 自定义用例
        caseCheck(new PrefixSumSolution(), 2, "[10,5,-3,3,2,null,11,3,-2,null,1]", 1);
        caseCheck(new PrefixSumSolution(), 0, "[10,5,-3,3,2,null,11,3,-2,null,1]", 0);
        caseCheck(new PrefixSumSolution(), 0, "[10,5,-3,3,2,null,11,3,-2,null,1]", 100);
    }

    private static void caseCheck(PrefixSumSolution solution, int expected, String treeStr, int targetSum) {
        CaseAssertUtils.assertEquals(expected, solution.pathSum(StructConvertUtils.convertToTreeNode(treeStr), targetSum));
    }
}
