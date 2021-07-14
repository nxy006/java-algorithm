package com.nxy006.project.algorithm.leetcode.p0038.count_and_say;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String s = countAndSay(n-1);
        char curr = '.';
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c != curr) {
                if (cnt != 0) {
                    sb.append(cnt).append(curr);
                }
                curr = c;
                cnt = 0;
            }
            cnt++;
        }
        if (cnt != 0) {
            sb.append(cnt).append(curr);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "1",1);
        caseCheck(new Solution(), "1211",4);
        // 自定义用例
        caseCheck(new Solution(), "11",2);
        caseCheck(new Solution(), "21",3);
        caseCheck(new Solution(), "111221",5);
    }

    private static void caseCheck(Solution solution, String expected, int n) {
        CaseAssertUtils.assertEquals(expected, solution.countAndSay(n));
    }
}
