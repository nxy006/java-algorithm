package com.nxy006.project.algorithm.leetcode.p1877.minimize_maximum_pair_sum_in_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 排序后双指针扫描解法
 * 时间复杂度：O(n log_n)，空间复杂度：O(log_n)，空间复杂度为排序的栈开销
 *
 * Runtime  49 ms   , beats 96.71 % of java submissions.
 * Memory   54.6 MB , beats 84.07 % of java submissions.
 * 07/20/2021 22:26
 */
public class TwoPointWithSortSolution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1, ans = 0;
        while(l < r) {
            ans = Integer.max(ans, nums[l++] + nums[r--]);
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointWithSortSolution(), 7, "[3,5,2,3]");
        caseCheck(new TwoPointWithSortSolution(), 8, "[3,5,4,2,4,6]");
    }

    private static void caseCheck(TwoPointWithSortSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.minPairSum(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
