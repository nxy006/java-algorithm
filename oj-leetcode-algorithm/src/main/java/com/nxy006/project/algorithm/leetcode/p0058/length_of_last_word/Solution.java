package com.nxy006.project.algorithm.leetcode.p0058.length_of_last_word;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 常规解法
 *
 * Runtime  2 ms   , beats 14.51 % of java submissions.
 * Memory   37.2 MB , beats 73.48 % of java submissions.
 * 07/20/2021 22:35
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (i != 0 && s.charAt(i) != ' ' && s.charAt(i-1) == ' ') {
                cnt = 0;
            }
            cnt++;
        }
        return cnt;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(5, new Solution().lengthOfLastWord("Hello World"));
        CaseAssertUtils.assertEquals(0, new Solution().lengthOfLastWord(" "));
        // 自定义用例
        CaseAssertUtils.assertEquals(3, new Solution().lengthOfLastWord("jeiafj   cefkoaf d  eic"));
        CaseAssertUtils.assertEquals(3, new Solution().lengthOfLastWord("check then act  "));
        CaseAssertUtils.assertEquals(1, new Solution().lengthOfLastWord("a "));
    }
}
