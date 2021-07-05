package com.nxy006.project.algorithm.leetcode.p1220.count_vowels_permutation;

import java.util.Arrays;

/**
 * 动态规划解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 本解法中 nums[] 表示以 aeiou 结尾的单词的数量，比如 a 能跟在 eui 后面
 *
 * Runtime  16 ms   , beats  61.60 % of java submissions.
 * Memory   38.9 MB , beats  51.66 % of java submissions.
 * 07/04/2021 22:38
 */
public class DPOptimizedSpaceSolution {
    private static final int M = 1000000007;
    public int countVowelPermutation(int n) {
        long[] nums = new long[]{1, 1, 1, 1, 1};
        for(int i = 1; i < n; i++) {
            long[] arr = new long[5];
            arr[0] = (nums[1] + nums[2] + nums[4])  % M;   // a = 'e' + 'u' + 'i'
            arr[1] = (nums[0] + nums[2])            % M;   // e = 'a' + 'i'
            arr[2] = (nums[1] + nums[3])            % M;   // i = 'e' + 'o'
            arr[3] = (nums[2])                      % M;   // o = 'i'
            arr[4] = (nums[2] + nums[3])            % M;   // u = 'o' + 'i'
            nums = arr;
        }
        return (int) (Arrays.stream(nums).sum() % M);
    }
}
