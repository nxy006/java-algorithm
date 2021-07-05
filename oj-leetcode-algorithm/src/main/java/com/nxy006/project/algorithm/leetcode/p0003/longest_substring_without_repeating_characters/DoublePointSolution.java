package com.nxy006.project.algorithm.leetcode.p0003.longest_substring_without_repeating_characters;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  3 ms    , beats 89.50 % of java submissions.
 * Memory   38.9 MB , beats 85.98 % of java submissions.
 * 07/05/2021 17:04
 */
public class DoublePointSolution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];                               // 数组用于保存每个字符的上次出现位置，从未出现记录为 -1
        Arrays.fill(arr, -1);

        int l = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            l = Integer.max(l, arr[s.charAt(i)] + 1);;      // 如果本字符已经在当前范围内出现过，则更新左边界为上次出现位置 + 1
            arr[s.charAt(i)] = i;                               // 更新当前字符的最后出现位置
            res = Integer.max(res, i-l+1);                  // i-left+1 表示以本字符为结尾时，不含重复字符的最大长度
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new DoublePointSolution(), 3, "abcabcbb");
        caseCheck(new DoublePointSolution(), 1, "bbbbb");
        caseCheck(new DoublePointSolution(), 3, "pwwkew");
        caseCheck(new DoublePointSolution(), 0, "");
    }

    private static void caseCheck(DoublePointSolution solution, int expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.lengthOfLongestSubstring(s));
    }
}
