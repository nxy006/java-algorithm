package com.nxy006.project.algorithm.leetcode.p2196.create_binary_tree_from_descriptions;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 解法
 * 时间复杂度：O(n+depth)，空间复杂度：O(n)
 *
 * Runtime  113 ms   , beats  25.00 % of java submissions.
 * Memory   119.1 MB , beats  25.00 % of java submissions.
 * 03/07/2022 00:28
 */
public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        for(int[] description : descriptions) {
            TreeNode parentNode = map.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode childNode = map.getOrDefault(description[1], new TreeNode(description[1]));

            if (description[2] == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            map.put(description[0], parentNode);
            map.put(description[1], childNode);
            parentMap.put(description[1], description[0]);
        }

        int currentNode = descriptions[0][0];
        while(parentMap.containsKey(currentNode)) {
            currentNode = parentMap.get(currentNode);
        }
        return map.get(currentNode);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[50,20,80,15,17,19]", "[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]");
        caseCheck(new Solution(), "[1,2,null,null,3,4]", "[[1,2,1],[2,3,0],[3,4,1]]");
    }

    private static void caseCheck(Solution solution, String expectedTreeStr, String descriptionsStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToTreeNode(expectedTreeStr),
                solution.createBinaryTree(StructConvertUtils.convertToIntMatrix(descriptionsStr)));
    }
}
