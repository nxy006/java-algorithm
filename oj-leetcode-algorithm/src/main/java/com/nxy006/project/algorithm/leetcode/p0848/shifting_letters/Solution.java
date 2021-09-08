package com.nxy006.project.algorithm.leetcode.p0848.shifting_letters;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 常规解法
 *
 * Runtime  19 ms   , beats 22.68 % of java submissions.
 * Memory   97.6 MB , beats 11.90 % of java submissions.
 * 09/08/2021 22:23
 */
public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        int shift = 0;
        for(int i = shifts.length-1; i >= 0; i--) {
            shift = (shift + (shifts[i] % 26)) % 26;                // 注意：shift 要避免越界
            arr[i] = (char)('a' + (arr[i] - 'a' + shift) % 26);
        }
        return new String(arr);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "rpl", "abc", "[3,5,9]");
        caseCheck(new Solution(), "gfd", "aaa", "[1,2,3]");
        // 提交失败用例
        caseCheck(new Solution(), "wqqwlcjnkphhsyvrkdod", "mkgfzkkuxownxvfvxasy",
                "[505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513]");
    }

    private static void caseCheck(Solution solution, String expected, String s, String shiftsArr) {
        CaseAssertUtils.assertEquals(expected,
                solution.shiftingLetters(s, StructConvertUtils.convertToIntArray(shiftsArr)));
    }
}
