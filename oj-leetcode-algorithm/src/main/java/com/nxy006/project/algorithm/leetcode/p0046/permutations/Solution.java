package com.nxy006.project.algorithm.leetcode.p0046.permutations;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, boolean[] exist, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {
            if (!exist[i]) {
                exist[i] = true;
                list.add(nums[i]);
                process(nums, exist, res, list);
                exist[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", "[1,2,3]");
        caseCheck(new Solution(), "[[0,1],[1,0]]", "[0,1]");
    }

    private static void caseCheck(Solution solution, String expected, String numsStr) {
        // TODO 实际应该是忽略顺序的比较
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntegerNestedList(expected), solution.permute(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
