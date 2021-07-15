package com.nxy006.project.algorithm.leetcode.p0047.permutations_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归解法
 *
 * Runtime  1 ms  , beats 99.43 % of java submissions.
 * Memory   40 MB , beats 25.81 % of java submissions.
 * 07/15/2021 23:30
 */
public class RecursionSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, boolean[] exist, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i-1] == nums[i] && !exist[i-1]) {
                continue;
            }
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
        caseCheck(new RecursionSolution(), "[[1,1,2],[1,2,1],[2,1,1]]", "[1,1,2]");
        caseCheck(new RecursionSolution(), "[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]", "[1,2,3]");
        // 自定义用例
        caseCheck(new RecursionSolution(), "[[1,1,1]]", "[1,1,1]");
        caseCheck(new RecursionSolution(), "[[5]]", "[5]");
    }

    private static void caseCheck(RecursionSolution solution, String expected, String numsStr) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToIntegerNestedList(expected), solution.permuteUnique(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
