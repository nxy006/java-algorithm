package com.nxy006.project.algorithm.leetcode.p0056.merge_intervals;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        List<Pair<Integer, Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for(int[] interval : intervals) {
            if (end < interval[0]) {                    // 与当前范围不相交
                list.add(new Pair<>(start, end));
                start = interval[0];
                end = interval[1];
            } else {
                end = Integer.max(end, interval[1]);
            }
        }
        list.add(new Pair<>(start, end));

        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> pair = list.get(i);
            ans[i][0] = pair.getKey();
            ans[i][1] = pair.getValue();
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,6],[8,10],[15,18]]","[[1,3],[2,6],[8,10],[15,18]]");
        caseCheck(new Solution(), "[[1,5]]","[[1,4],[4,5]]");
        // 自定义用例
        caseCheck(new Solution(), "[[1,1]]","[[1,1],[1,1],[1,1]]");
        caseCheck(new Solution(), "[[1,6]]","[[1,1],[2,2],[1,6]]");
        caseCheck(new Solution(), "[[1,3],[5,8],[9,10]]","[[1,3],[9,10],[5,8]]");
        caseCheck(new Solution(), "[[1,3]]","[[1,3]]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expectedStr), solution.merge(StructConvertUtils.convertToIntMatrix(numsStr)));
    }
}
