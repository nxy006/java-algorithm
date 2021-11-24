package com.nxy006.project.algorithm.leetcode.p0986.interval_list_intersections;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * 常规解法
 *
 * Runtime 7 ms    , beats 14.52 % of java submissions.
 * Memory  51.9 MB , beats 27.67 % of java submissions.
 * 11/25/2021 01:06
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        int prevJ = 0;
        for(int i = 0; i < firstList.length; i++) {
            for(int j = prevJ; j < secondList.length; j++) {
                if (firstList[i][1] < secondList[j][0]) {
                    break;
                } else if (secondList[j][1] < firstList[i][0]) {
                    continue;
                } else if (secondList[j][0] <= firstList[i][0] && firstList[i][1] <= secondList[j][1]) {
                    list.add(new Pair<>(firstList[i][0], firstList[i][1]));
                } else {
                    list.add(new Pair<>(Integer.max(firstList[i][0], secondList[j][0]), Integer.min(firstList[i][1], secondList[j][1])));
                }
                prevJ = j;
            }
        }

        if (list.size() == 0) {
            return new int[][]{};
        }

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
        caseCheck(new Solution(), "[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]","[[0,2],[5,10],[13,23],[24,25]]", "[[1,5],[8,12],[15,24],[25,26]]");
        caseCheck(new Solution(), "[]","[[1,3],[5,9]]", "[]");
        caseCheck(new Solution(), "[]","[]", "[[4,8],[10,12]]");
        caseCheck(new Solution(), "[[3,7]]","[[1,7]]", "[[3,10]]");
        // Wrong Answer 用例
        caseCheck(new Solution(), "[[5,6],[7,8],[10,10]]","[[4,6],[7,8],[10,17]]", "[[5,10]]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String firstListStr, String secondListStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntMatrix(expectedStr),
                solution.intervalIntersection(
                        StructConvertUtils.convertToIntMatrix(firstListStr), StructConvertUtils.convertToIntMatrix(secondListStr))
        );
    }
}
