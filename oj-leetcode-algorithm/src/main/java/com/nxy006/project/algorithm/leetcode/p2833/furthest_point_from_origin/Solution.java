package com.nxy006.project.algorithm.leetcode.p2833.furthest_point_from_origin;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 模拟算法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  1 ms    , beats  100.00 % of java submissions.
 * Memory   41.2 MB , beats  50.00 % of java submissions.
 * 27/08/2023 10:33
 */
public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, distance = 0;
        for (char c : moves.toCharArray()) {
            switch(c) {
                case 'L': l++;break;
                case 'R': r++;break;
                case '_': distance++;
            }
        }

        return Math.abs(l-r) + distance;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "L_RL__R", 3);
        caseCheck(new Solution(), "_R__LL_", 5);
        caseCheck(new Solution(), "_______", 7);
    }

    private static void caseCheck(Solution solution, String str, int expected) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.furthestDistanceFromOrigin(str));
    }
}
