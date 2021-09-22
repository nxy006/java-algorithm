package com.nxy006.project.algorithm.leetcode.p0485.max_consecutive_ones;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  2 ms    , beats 63.24 % of java submissions.
 * Memory   40.6 MB , beats 37.10 % of java submissions.
 * 09/22/2021 12:42
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for(int num : nums) {
            count = num == 1 ? count + 1 : 0;
            res = Integer.max(res, count);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 3, "[1,1,0,1,1,1]");
        caseCheck(new Solution(), 2, "[1,0,1,1,0,1]");
        // 自定义用例
        caseCheck(new Solution(), 4, "[1,1,1,1]");
        caseCheck(new Solution(), 0, "[0,0,0,0,0]");
    }

    private static void caseCheck(Solution solution, int expected, String movesString) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.findMaxConsecutiveOnes(StructConvertUtils.convertToIntArray(movesString)));
    }
}
