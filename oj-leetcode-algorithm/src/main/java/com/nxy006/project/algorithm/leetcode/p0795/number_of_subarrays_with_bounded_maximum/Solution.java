package com.nxy006.project.algorithm.leetcode.p0795.number_of_subarrays_with_bounded_maximum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 解法 <br/>
 * 参考：<a href="https://www.cnblogs.com/grandyang/p/9237967.html">https://www.cnblogs.com/grandyang/p/9237967.html<a/>
 */
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 最大值在 [L, R] 范围的子数组数量 = 最大值在 [0, R] 范围的子数组数量 - 最大值在 [0, L-1] 范围的子数组数量
        return countSubarrayWithBounded(nums, right) - countSubarrayWithBounded(nums, left-1);
    }

    private int countSubarrayWithBounded(int[] nums, int bounded) {
        int ans = 0, cur = 0;;
        for(int i = 0; i < nums.length; i++) {
            cur = (nums[i] <= bounded) ? cur+1 : 0;
            ans += cur;
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), "2,1,4,3", 2, 3, 3);
        caseCheck(new Solution(), "2,3,4,3", 2, 3, 4);
        caseCheck(new Solution(), "73,55,36,5,55,14,9,7,72,52", 32, 69, 22);
    }

    private static void caseCheck(Solution solution, String s, int left, int right, int expected) {
        CaseAssertUtils.assertEquals(expected, solution.numSubarrayBoundedMax(StructConvertUtils.convertToIntArray(s, ","), left, right));
    }
}