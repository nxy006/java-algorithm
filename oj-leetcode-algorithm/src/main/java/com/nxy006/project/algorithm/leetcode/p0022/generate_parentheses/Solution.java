package com.nxy006.project.algorithm.leetcode.p0022.generate_parentheses;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归枚举解法：递归尝试所有可用的组合顺序
 */
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, 0, new StringBuilder());
        return ans;
    }

    // l 可用的左括号数量，r 可用的右括号数量
    private void generateParenthesis(int n, int l, int r, StringBuilder sb) {
        if (sb.length() == 2*n) {
            ans.add(sb.toString());
            return ;
        }

        if (l > 0) {
            sb.append("(");
            generateParenthesis(n, l-1, r+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (r > 0) {
            sb.append(")");
            generateParenthesis(n, l, r-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), 3, "((())) (()()) (())() ()(()) ()()()");
        caseCheck(new Solution(), 1, "()");
    }

    private static void caseCheck(Solution solution, int n, String expected) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringList(expected), solution.generateParenthesis(n));
    }
}
