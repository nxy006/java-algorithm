package com.nxy006.project.algorithm.leetcode.p0051.n_queens;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        process(n, new boolean[n], new boolean[4*n], new boolean[4*n], 0, res, new ArrayList<>());
        return res;
    }

    private void process(int n, boolean[] cols, boolean[] first, boolean[] second, int k, List<List<String>> res, List<String> list) {
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int i = 0; i < n; i++) {
            if (cols[i] || first[n+k-i] || second[n+i+k]) continue;

            list.add(generateString(n, i));
            cols[i] = first[n+k-i] = second[n+i+k] = true;

            process(n, cols, first, second, k+1, res, list);

            list.remove(list.size()-1);
            cols[i] = first[n+k-i] = second[n+i+k] = false;
        }
    }

    // 组装字符串
    private String generateString(int n, int i) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < i; j++) sb.append('.');
        sb.append('Q');
        for(int j = i+1; j < n; j++) sb.append('.');
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]", 4);
        caseCheck(new Solution(), "[[\"Q\"]]", 1);
    }

    private static void caseCheck(Solution solution, String expected, int n) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringNestedList(expected), solution.solveNQueens(n));
    }
}
