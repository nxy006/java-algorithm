package com.nxy006.project.algorithm.leetcode.p0095.unique_binary_search_trees_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * 常规解法
 *
 * Runtime  1 ms    , beats 92.44 % of java submissions.
 * Memory   38.8 MB , beats 98.00 % of java submissions.
 * 08/03/2021 22:54
 */
public class Solution {
    private Map<Pair<Integer, Integer>, List<TreeNode>> resMap = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        if (start == end) return Collections.singletonList(new TreeNode(start));
        if (end < start) return Collections.singletonList(null);
        if (resMap.containsKey(new Pair<>(start, end))) {
            return resMap.get(new Pair<>(start, end));
        }

        List<TreeNode> list = new ArrayList<>();
        for(int i = start; i <= end; i++) {

            List<TreeNode> leftNodes = generateTrees(start, i-1), rightNodes = generateTrees(i+1, end);
            for(TreeNode leftNode : leftNodes) {
                for(TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        resMap.put(new Pair<>(start, end), list);
        return list;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]", 3);
        caseCheck(new Solution(), "[[1]]", 1);
    }

    private static void caseCheck(Solution solution, String expected, int n) {
        List<List<Integer>> list = StructConvertUtils.convertToIntegerNestedList(expected);
        List<TreeNode> expectedList = new ArrayList<>();
        for(List<Integer> nodeList : list) {
            expectedList.add(StructConvertUtils.convertToTreeNode(nodeList));
        }
        CaseAssertUtils.assertEquals(expectedList, solution.generateTrees(n));
    }
}
