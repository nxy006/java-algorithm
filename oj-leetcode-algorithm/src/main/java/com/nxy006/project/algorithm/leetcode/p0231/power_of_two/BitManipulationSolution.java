package com.nxy006.project.algorithm.leetcode.p0231.power_of_two;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 位运算解法
 * 时间复杂度：O(1)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats  99.97 % of java submissions.
 * Memory   35.8 MB , beats  89.66 % of java submissions.
 * 12/21/2021 23:54
 */
public class BitManipulationSolution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(true, new BitManipulationSolution().isPowerOfTwo(1));
        CaseAssertUtils.assertEquals(true, new BitManipulationSolution().isPowerOfTwo(16));
        CaseAssertUtils.assertEquals(false, new BitManipulationSolution().isPowerOfTwo(3));
    }
}
