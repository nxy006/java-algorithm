package com.nxy006.project.algorithm.leetcode.p0040.combination_sum_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归解法
 *
 * Runtime  2 ms  , beats 99.01 % of java submissions.
 * Memory   39 MB , beats 81.59 % of java submissions.
 * 07/15/2021 23:13
 */
public class RecursionSolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, 0, 0, res, new ArrayList<>(), new boolean[candidates.length]);
        return res;
    }

    private void process(int[] candidates, int target, int i, int sum, List<List<Integer>> res, List<Integer> list, boolean[] exists) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }

        for(; i < candidates.length; i++) {
            // 如果与上一个数相同，且上一个数没有被选中，则当前数字也不能被选中
            if (i != 0 && candidates[i-1] == candidates[i] && !exists[i-1]) {
                continue;
            }
            if (sum + candidates[i] <= target) {
                exists[i] = true;
                list.add(candidates[i]);
                process(candidates, target, i+1, sum + candidates[i], res, list, exists);
                list.remove(list.size()-1);
                exists[i] = false;
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "[[1,1,6],[1,2,5],[1,7],[2,6]]", "[10,1,2,7,6,1,5]",8);
        caseCheck(new RecursionSolution(), "[[1,2,2],[5]]", "[2,5,2,1,2]",5);
    }

    private static void caseCheck(RecursionSolution solution, String expected, String numsStr, int target) {
        // TODO 实际应该是忽略顺序的比较
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntegerNestedList(expected), solution.combinationSum2(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
