package com.nxy006.project.algorithm.leetcode.p0096.unique_binary_search_trees;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    private int[] res = new int[20];

    public int numTrees(int n) {
        if (n <= 0) return 1;
        if (n == 1 || n == 2) return n;
        if (res[n] != 0) return res[n];

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += numTrees(i) * numTrees(n-i-1);
        }
        return res[n] = ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(5, new Solution().numTrees(3));
        CaseAssertUtils.assertEquals(1, new Solution().numTrees(1));
        // 自定义用例
        CaseAssertUtils.assertEquals(14, new Solution().numTrees(4));
    }
}
