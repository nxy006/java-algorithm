package com.nxy006.project.algorithm.leetcode.p0394.decode_string;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 常规解法
 * 时间复杂度：O(n)，空间复杂度：O(m)，m 为子表达式的最大深度，即栈深度
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   37 MB , beats  85.43 % of java submissions.
 * 12/19/2021 22:50
 */
public class Solution {
    public String decodeString(String s) {
        return decodeString(s, 1);
    }

    public String decodeString(String s, int n) {
        // numStart 数字开始位置，start 方括号起始位置，left、right 左右方括号数量
        int numStart = -1, start = -1, left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left == 0) {
                if ('0' <= c && c <= '9') {
                    if (numStart == -1) {
                        numStart = i;
                    }
                } else if (c == '[') {
                    start = i;
                    left++;
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '[') left++;
                if (c == ']') right++;

                if (left == right) {
                    sb.append(decodeString(s.substring(start+1, i), Integer.valueOf(s.substring(numStart, start))));
                    numStart = -1;
                    start = -1;
                    left = 0;
                    right = 0;
                }
            }
        }

        String str = sb.toString();
        for(int i = 1; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("aaabcbc", new Solution().decodeString("3[a]2[bc]"));
        CaseAssertUtils.assertEquals("accaccacc", new Solution().decodeString("3[a2[c]]"));
        CaseAssertUtils.assertEquals("abcabccdcdcdef", new Solution().decodeString("2[abc]3[cd]ef"));
        CaseAssertUtils.assertEquals("abccdcdcdxyz", new Solution().decodeString("abc3[cd]xyz"));
        // 提交失败用例
        CaseAssertUtils.assertEquals(
                "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode" +
                        "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"
                , new Solution().decodeString("100[leetcode]"));
    }
}
