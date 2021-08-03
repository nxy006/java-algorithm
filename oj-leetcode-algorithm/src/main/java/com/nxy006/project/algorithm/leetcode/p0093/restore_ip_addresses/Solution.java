package com.nxy006.project.algorithm.leetcode.p0093.restore_ip_addresses;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO 待提交测试
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        process(s, 0, res, new ArrayList<>());
        return res;
    }

    private void process(String s, int i, List<String> res, List<String> list) {
        if (list.size() == 4) {
            if (i != s.length()) {
                return ;
            }
            res.add(String.join(".", list));
        }
        if (list.size() > 4 || i >= s.length() || s.length() - i < (4 - list.size()) || s.length() - i > (4 - list.size()) * 3) {
            // 范围超限，或剩下的字符串已经不足以生成有效 IP 地址
            return ;
        }

        for(int j = 1; j <= 3 && i+j <= s.length(); j++) {
            String number = s.substring(i, i+j);
            if (validNumber(number)) {
                list.add(number);
                process(s, i+j, res, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean validNumber(String s) {
        if (s.charAt(0) == '0') {
            return s.length() == 1;
        }
        if (s.length() <= 2) {
            // 1-99 correct
            return true;
        }

        switch (s.charAt(0)) {
            case '1':
                // 100-199 correct
                return true;
            case '2':
                // 200-255 correct; 256-299 incorrect
                return (s.charAt(1) < '5' || s.charAt(1) == '5' && s.charAt(2) <= '5');
        }
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[\"255.255.11.135\",\"255.255.111.35\"]", "25525511135");
        caseCheck(new Solution(), "[\"0.0.0.0\"]", "0000");
        caseCheck(new Solution(), "[\"1.1.1.1\"]", "1111");
        caseCheck(new Solution(), "[\"0.10.0.10\",\"0.100.1.0\"]", "010010");
        caseCheck(new Solution(), "[\"1.0.10.23\",\"1.0.102.3\",\"10.1.0.23\",\"10.10.2.3\",\"101.0.2.3\"]", "101023");
        // 自定义用例
        caseCheck(new Solution(), "[]", "0");
        caseCheck(new Solution(), "[]", "1010235782786446578272");
        caseCheck(new Solution(), "[\"99.9.9.9\",\"9.99.9.9\",\"9.9.99.9\",\"9.9.9.99\"]", "99999");
        caseCheck(new Solution(), "[\"99.0.0.9\",\"9.90.0.9\"]", "99009");
    }

    private static void caseCheck(Solution solution, String expectedList, String s) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringList(expectedList), solution.restoreIpAddresses(s));
    }
}
