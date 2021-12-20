package com.nxy006.project.algorithm.leetcode.p1200.minimum_absolute_difference;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常规解法
 * 时间复杂度：O(n·log n)，空间复杂度：O(n)
 *
 * Runtime  14 ms   , beats 97.12 % of java submissions.
 * Memory   49.8 MB , beats 89.52 % of java submissions.
 * 12/20/2021 23:45
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            if (diff < minDiff) {
                minDiff = diff;
                res = new ArrayList<>();
            }

            if (diff == minDiff) {
                res.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,2],[2,3],[3,4]]", "[4,2,1,3]");
        caseCheck(new Solution(), "[[1,3]]", "[1,3,6,10,15]");
        caseCheck(new Solution(), "[[-14,-10],[19,23],[23,27]]", "[3,8,-10,23,19,-4,-14,27]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String arrStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntegerNestedList(expectedStr),
                solution.minimumAbsDifference(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
