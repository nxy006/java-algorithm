package com.nxy006.project.algorithm.leetcode.p2195.append_k_integers_with_minimal_sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  23 ms   , beats  50.00 % of java submissions.
 * Memory   82.7 MB , beats  50.00 % of java submissions.
 * 03/07/2022 00:16
 */
public class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            sum += nums[i];
            k++;
        }
        return computeSum(1, k) - sum;
    }

    private long computeSum(int start, int n) {
        return (long) n * (start * 2 + (n-1)) / 2;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 5, "[1,4,25,10,25]", 2);
        caseCheck(new Solution(), 25, "[5,6]", 6);
        // 提交失败用例
        caseCheck(new Solution(), 5000000050000000L, "[1000000000]", 100000000);
        caseCheck(new Solution(), 5000000050000001L, "[100000000]", 100000000);
        caseCheck(new Solution(), 5, "[1,4,25,10,25,1,1,4,10,25,25,1,4]", 2);
    }

    private static void caseCheck(Solution solution, long expected, String numsStr, int k) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.minimalKSum(StructConvertUtils.convertToIntArray(numsStr), k));
    }
}
