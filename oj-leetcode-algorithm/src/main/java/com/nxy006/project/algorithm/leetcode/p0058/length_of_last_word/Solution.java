package com.nxy006.project.algorithm.leetcode.p0058.length_of_last_word;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if (c == ' ') cnt = 0;
            else cnt++;
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
        CaseAssertUtils.assertEquals(0, new Solution().lengthOfLastWord("check then act  "));
    }
}
