package com.nxy006.project.algorithm.leetcode.p0017.letter_combinations_of_a_phone_number;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯解法（递归）
 * 时间复杂度：O(3^m·4^n)，空间复杂度：O(m+n)：其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数
 *
 * Runtime  1 ms    , beats 71.09 % of java submissions.
 * Memory   39.3 MB , beats 22.07 % of java submissions.
 * 07/09/2021 23:50
 */
public class Solution {
    private final String[] btns = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();   // 不能一次通过：边界考虑不完善，无此判断会返回 [""] 而非 []

        List<String> res = new ArrayList<>();
        process(digits, 0, res, new StringBuilder());
        return res;
    }

    private void process(String digits, int i, List<String> res, StringBuilder sb) {
        if (i >= digits.length()) {
            res.add(sb.toString());
            return ;
        }

        for(char c : btns[digits.charAt(i) - '1'].toCharArray()) {
            sb.append(c);
            process(digits, i+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), "[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]", "23");
        caseCheck(new Solution(), "[]", "1");
        caseCheck(new Solution(), "[\"a\",\"b\",\"c\"]", "2");
    }

    private static void caseCheck(Solution solution, String expected, String digits) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringList(expected), solution.letterCombinations(digits));
    }
}
