package com.nxy006.project.algorithm.leetcode.p0039.combination_sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解法
 *
 * Runtime  2 ms  , beats 98.36 % of java submissions.
 * Memory   39 MB , beats 80.92 % of java submissions.
 * 07/15/2021 01:44
 */
public class RecursionSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        process(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void process(int[] candidates, int target, int i, int sum, List<List<Integer>> res, List<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }

        for(; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                list.add(candidates[i]);
                process(candidates, target, i, sum + candidates[i], res, list);
                list.remove(list.size()-1);
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "[[2,2,3],[7]]", "[2,3,6,7]",7);
        caseCheck(new RecursionSolution(), "[[2,2,2,2],[2,3,3],[3,5]]", "[2,3,5]",8);
        caseCheck(new RecursionSolution(), "[[]]", "[2]",1);
        caseCheck(new RecursionSolution(), "[[1]]", "[1]",1);
        caseCheck(new RecursionSolution(), "[[1,1]]", "[1]",2);
    }

    private static void caseCheck(RecursionSolution solution, String expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntegerNestedList(expected), solution.combinationSum(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
