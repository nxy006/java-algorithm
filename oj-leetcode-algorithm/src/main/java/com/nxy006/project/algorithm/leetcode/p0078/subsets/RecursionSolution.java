package com.nxy006.project.algorithm.leetcode.p0078.subsets;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class RecursionSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void process(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));

        for(; index < nums.length; index++) {
            list.add(nums[index]);
            process(nums, res, list, index+1);
            list.remove(list.size()-1);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]", "[1,2,3]");
        caseCheck(new RecursionSolution(), "[[],[0]]", "[0]");
    }

    private static void caseCheck(RecursionSolution solution, String expected, String numsStr) {
        // TODO 实际内层 List 也不要求排序
        CaseAssertUtils.assertEqualsIgnoreOrder(
                StructConvertUtils.convertToIntegerNestedList(expected),
                solution.subsets(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
