package com.nxy006.project.algorithm.leetcode.p0012.integer_to_roman;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 数学解法
 * 时间复杂度：O(1)：由于输入长度是固定的 13 字符且每个字符的出现次数均不超过 3，因此循环次数有一个确定的上限，本题不会超过 15 次。
 * 空间复杂度：O(1)
 *
 * Runtime  4 ms    , beats 77.48 % of java submissions.
 * Memory   38.4 MB , beats 74.33 % of java submissions.
 * 07/09/2021 00:14
 */
public class MathSolution {
    private final int[]    nums   =    new int[]{1,   4,    5,   9,    10,  40,   50,  90,   100, 400,  500, 900,  1000};
    private final String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

    public String intToRoman(int num) {
        int i = nums.length - 1;
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            while (nums[i] > num) i--;

            for(int j = 0; j < num/nums[i]; j++) {
                sb.append(romans[i]);
            }
            num %= nums[i];
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals("III", new MathSolution().intToRoman(3));
        CaseAssertUtils.assertEquals("IV", new MathSolution().intToRoman(4));
        CaseAssertUtils.assertEquals("IX", new MathSolution().intToRoman(9));
        CaseAssertUtils.assertEquals("LVIII", new MathSolution().intToRoman(58));
        CaseAssertUtils.assertEquals("MCMXCIV", new MathSolution().intToRoman(1994));
    }
}
