package com.nxy006.project.algorithm.leetcode.p0017.letter_combinations_of_a_phone_number;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    private final String[] btns = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "xyz"};

    public List<String> letterCombinations(String digits) {
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
