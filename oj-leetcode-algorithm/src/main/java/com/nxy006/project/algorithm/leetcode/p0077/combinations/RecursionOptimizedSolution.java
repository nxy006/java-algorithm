package com.nxy006.project.algorithm.leetcode.p0077.combinations;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解法（优化）
 * 时间复杂度：O({n, k}·k)，即 n 个数取 k 个数的组合数量乘以 k
 * 空间复杂度：O(k)，栈深度
 *
 * Runtime  2 ms    , beats 91.31 % of java submissions.
 * Memory   40.1 MB , beats 87.73 % of java submissions.
 * 07/23/2021 23:35
 */
public class RecursionOptimizedSolution {
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
        // 优化点：如果剩余的元素已经不足以凑足剩余的元素，直接退出
        if (n - i + 1 < k - list.size()) {
            return ;
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
        caseCheck(new RecursionOptimizedSolution(), "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]", 4, 2);
        caseCheck(new RecursionOptimizedSolution(), "[[1]]", 1, 1);
    }

    private static void caseCheck(RecursionOptimizedSolution solution, String expected, int n, int k) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToIntegerNestedList(expected), solution.combine(n, k));
    }
}
