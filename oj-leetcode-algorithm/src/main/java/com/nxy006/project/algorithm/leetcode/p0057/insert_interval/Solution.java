package com.nxy006.project.algorithm.leetcode.p0057.insert_interval;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int[] interval : intervals) {
            if (interval[1] < newInterval[0] || newInterval[1] < interval[0]) {
                list.add(new Pair<>(interval[0], interval[1]));
            } else if (newInterval[0] <= interval[0] && interval[1] <= newInterval[1]) {
                continue;
            } else {
                newInterval[0] = Integer.min(newInterval[0], interval[0]);
                newInterval[1] = Integer.max(newInterval[1], interval[1]);
            }
        }

        int[][] ans = new int[list.size()+1][2];
        int i = 0;
        for (Pair<Integer, Integer> pair : list) {
            if (newInterval[0] < pair.getKey()) {
                ans[i][0] = newInterval[0];
                ans[i][1] = newInterval[1];
                i++;
                newInterval[0] = Integer.MAX_VALUE;
            }
            ans[i][0] = pair.getKey();
            ans[i][1] = pair.getValue();
            i++;
        }
        if (i != list.size()+1) {
            ans[i][0] = newInterval[0];
            ans[i][1] = newInterval[1];
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,5],[6,9]]","[[1,3],[6,9]]", "[2,5]");
        caseCheck(new Solution(), "[[1,2],[3,10],[12,16]]","[[1,2],[3,5],[6,7],[8,10],[12,16]]", "[4,8]");
        caseCheck(new Solution(), "[[5,7]]","[[]]", "[5,7]");
        caseCheck(new Solution(), "[[1,5]]","[[1,5]]", "[2,3]");
        caseCheck(new Solution(), "[[1,7]]","[[1,5]]", "[2,7]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr, String newIntervalStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntMatrix(expectedStr),
                solution.insert(StructConvertUtils.convertToIntMatrix(numsStr), StructConvertUtils.convertToIntArray(newIntervalStr)));
    }
}
