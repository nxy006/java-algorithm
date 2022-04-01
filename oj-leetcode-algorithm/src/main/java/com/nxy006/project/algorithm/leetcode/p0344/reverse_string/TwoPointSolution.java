package com.nxy006.project.algorithm.leetcode.p0344.reverse_string;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 双指针解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  14 ms   , beats 100.00 % of java submissions.
 * Memory   49.3 MB , beats  86.52 % of java submissions.
 * 04/01/2022 23:34
 */
public class TwoPointSolution {
    public void reverseString(char[] s) {
        for(int l = 0, r = s.length-1; l < r; l++, r--) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointSolution(), "[\"o\",\"l\",\"l\",\"e\",\"h\"]", "[\"h\",\"e\",\"l\",\"l\",\"o\"]");
        caseCheck(new TwoPointSolution(), "[\"h\",\"a\",\"n\",\"n\",\"a\",\"H\"]", "[\"H\",\"a\",\"n\",\"n\",\"a\",\"h\"]");
        // 自定义用例
        caseCheck(new TwoPointSolution(), "[\"a\"]", "[\"a\"]");
    }

    // TODO 方法调用不正确，实际调用 assertEquals(Object expected, Object actual)
    private static void caseCheck(TwoPointSolution solution, String expectedStr, String sStr) {
        char[] input = StructConvertUtils.convertToCharArray(sStr);
        solution.reverseString(input);
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToCharArray(expectedStr),
                input);
    }
}
