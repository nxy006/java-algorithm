package com.nxy006.project.algorithm.leetcode.p2848.points_that_intersect_with_carsn;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.List;

/**
 * 模拟算法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  2 ms     , beats  92.86 % of java submissions.
 * Memory   43.50 MB , beats  41.27 % of java submissions.
 * 10/09/2023 10:36
 */
public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] numArr = new int[101];

        for(List<Integer> list : nums) {
            for(int i = list.get(0); i <= list.get(1); i++) {
                numArr[i] = 1;
            }
        }

        int cnt = 0;
        for(int i = 1; i <= 100; i++) {
            cnt += numArr[i];
        }
        return cnt;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), 7, "[[3,6],[1,5],[4,7]]");
        caseCheck(new Solution(), 7, "[[1,3],[5,8]]");
    }

    private static void caseCheck(Solution solution, int expected, String nestedListStr) {
        CaseAssertUtils.assertEquals(expected,
                solution.numberOfPoints(StructConvertUtils.convertToIntegerNestedList(nestedListStr)));
    }
}
