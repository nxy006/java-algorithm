package com.nxy006.project.algorithm.leetcode.p0077.combinations;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class RecursionSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    public void process(int n, int k, List<List<Integer>> res, List<Integer> list, int i) {
        if (list.size() >= k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(; i <= n; i++) {
            list.add(i);
            process(n, k, res, list, i+1);
            list.remove(list.size()-1);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new RecursionSolution(), "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]", 4, 2);
        caseCheck(new RecursionSolution(), "[[1]]", 1, 1);
    }

    private static void caseCheck(RecursionSolution solution, String expected, int n, int k) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToIntegerNestedList(expected), solution.combine(n, k));
    }
}
