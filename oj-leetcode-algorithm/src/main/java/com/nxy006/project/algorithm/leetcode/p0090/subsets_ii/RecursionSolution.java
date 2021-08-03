package com.nxy006.project.algorithm.leetcode.p0090.subsets_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * TODO 待提交测试
 */
public class RecursionSolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void process(int[] nums, int i, List<List<Integer>> res, List<Integer> list, Set<Integer> existSet) {
        res.add(new ArrayList<>(list));

        for(; i < nums.length; i++) {
            // 如果当前值与上一值相等，则必须上一值被取到才能取当前值
            if (i > 0 && nums[i-1] == nums[i] && !existSet.contains(i-1)) {
                continue;
            }
            list.add(nums[i]);
            existSet.add(i);
            process(nums, i+1, res, list, existSet);
            list.remove(list.size()-1);
            existSet.remove(i);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "[[],[1],[1,2],[1,2,2],[2],[2,2]]", "[1,2,2]");
        caseCheck(new RecursionSolution(), "[[],[0]]", "[0]");
        // 自定义用例
        caseCheck(new RecursionSolution(), "[[],[1],[1,1],[1,1,1]]", "[1,1,1]");
        caseCheck(new RecursionSolution(), "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]", "[1,2,3]");
    }

    private static void caseCheck(RecursionSolution solution, String expected, String numsStr) {
        // TODO 实际内层 List 也不要求排序
        CaseAssertUtils.assertEqualsIgnoreOrder(
                StructConvertUtils.convertToIntegerNestedList(expected),
                solution.subsetsWithDup(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
