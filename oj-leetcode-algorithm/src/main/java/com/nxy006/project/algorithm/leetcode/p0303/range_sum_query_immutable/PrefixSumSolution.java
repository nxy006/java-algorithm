package com.nxy006.project.algorithm.leetcode.p0303.range_sum_query_immutable;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.List;

/**
 * 前缀和解法
 * 时间复杂度：初始化 O(n)，检索 O(1)
 * 空间复杂度：O(n)
 *
 * Runtime  6 ms    , beats 100.00 % of java submissions.
 * Memory   41.5 MB , beats  99.47 % of java submissions.
 * 08/17/2021 01:37
 */
public class PrefixSumSolution {
    private int[] nums;

    public PrefixSumSolution(int[] nums) {
        this.nums = nums;
        for(int i = 1; i < nums.length; i++) {
            this.nums[i] = this.nums[i-1] + this.nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return nums[right] - (left == 0 ? 0 : nums[left-1]);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck("[null, 1, -1, -3]",
                "[\"NumArray\", \"sumRange\", \"sumRange\", \"sumRange\"]",
                "[[-2, 0, 3, -5, 2, -1], [0, 2], [2, 5], [0, 5]]");
    }

    private static void caseCheck(String expectedStr, String commandsStr, String argsStr) {
        String[] commands = StructConvertUtils.convertToStringArray(commandsStr);
        int[][] args = StructConvertUtils.convertToIntMatrix(argsStr);
        List<Integer> expected = StructConvertUtils.convertToIntegerList(expectedStr);

        PrefixSumSolution solution = null;
        for(int i = 0; i < commands.length && i < args.length; i++) {
            switch (commands[i]) {
                case "NumArray":
                    solution = new PrefixSumSolution(args[i]);
                    break;
                case "sumRange":
                    CaseAssertUtils.assertEquals(expected.get(i).intValue(), solution.sumRange(args[i][0], args[i][1]));
                    break;
            }
        }
    }
}
