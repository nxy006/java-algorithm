package com.nxy006.project.algorithm.leetcode.p0049.group_anagrams;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * TODO 待提交测试
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String encodeStr = new String(chars);

            List<String> list = map.getOrDefault(encodeStr, new ArrayList<>());
            list.add(str);
            map.put(encodeStr, list);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]", "[\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]");
        caseCheck(new Solution(), "[[\"\"]]", "[\"\"]");
        caseCheck(new Solution(), "[[\"a\"]]", "[\"a\"]");
    }

    private static void caseCheck(Solution solution, String expected, String strsStr) {
        // TODO 修改为无关顺序的比较（两层 List 均顺序无关）
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringNestedList(expected), solution.groupAnagrams(StructConvertUtils.convertToStringArray(strsStr)));
    }
}
