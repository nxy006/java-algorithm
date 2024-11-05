package com.nxy006.project.algorithm.leetcode;

import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.*;

class Solution {
    private static Map<Pair<Integer, Integer>, Long> cache = new HashMap<>();
    public long maximumTotalCost(int[] nums) {
        if (nums.length == 1) return nums[0];

        return maxCost(buildTree(nums, 0, nums.length-1), nums.length, -1, 0);
    }

    private long maxCost(TreeNode root, int length, int index, long cost) {
        if (index == length-1) {
            return cost;
        }

        long result = Long.MIN_VALUE;
        for(int i = index+1; i < length; i++) {
            result = Math.max(
                    result,
                    maxCost(root, length, i, cost + sumWithCache(root, index+1, i)));
        }
        return result;
    }

    private long sumWithCache(TreeNode node, int i, int j) {
        Long result = cache.get(new Pair<>(i, j));
        if (result == null) {
            result = sum(node, i, j, i%2);
            cache.put(new Pair<>(i, j), result);
        }
        return result;
    }


    private long sum(TreeNode node, int i, int j, int flag) {
        if (node.maxIndex < i || node.minIndex > j) return 0;
        if (i <= node.minIndex && node.maxIndex <= j) {
            return flag == 0 ? node.value : node.value2;
        }

        return sum(node.left, i, j, flag) + sum(node.right, i, j, flag);
    }

    private TreeNode buildTree(int[] nums, int i, int j) {
        TreeNode root = new TreeNode(i, j);

        if (i == j) {
            root.value = nums[i] * (i%2==0 ? 1 : -1);
            root.value2 = nums[i] * (i%2==0 ? -1 : 1);
        } else {
            int mid = i+(j-i)/2;
            root.left = buildTree(nums, i, mid);
            root.right = buildTree(nums, mid+1, j);

            root.value = root.left.value + root.right.value;
            root.value2 = root.left.value2 + root.right.value2;
        }
        return root;

    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value, value2, minIndex, maxIndex;

        TreeNode() {
        }

        TreeNode(int minIndex, int maxIndex) {
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Cost is " + new Solution()
                    .maximumTotalCost(StructConvertUtils.convertToIntArray("[-13,3]")));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        [1,-2,3,4]
//        +1 +2 +3 -4
//          +3    -1
//             +2
//        -1
    }
}
