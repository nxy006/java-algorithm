package com.nxy006.project.algorithm.leetcode.p0151.reverse_words_in_a_string;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 常规解法
 * 按照空格拆分字符串，反向组装即可
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime 12 ms   , beats 33.40 % of java submissions.
 * Memory  41.5 MB , beats 18.51 % of java submissions.
 * 10/20/2021 23:30
 */
public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            if (str == null || str.length() == 0) {
                continue;
            }

            if (sb.length() > 0) {
                sb.insert(0, " ");
            }
            sb.insert(0, str);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("blue is sky the", new Solution().reverseWords("the sky is blue"));
        CaseAssertUtils.assertEquals("world hello", new Solution().reverseWords("  hello world  "));
        CaseAssertUtils.assertEquals("example good a", new Solution().reverseWords("a good   example"));
        CaseAssertUtils.assertEquals("Alice Loves Bob", new Solution().reverseWords("  Bob    Loves  Alice   "));
        CaseAssertUtils.assertEquals("bob like even not does Alice", new Solution().reverseWords("Alice does not even like bob"));
    }
}
