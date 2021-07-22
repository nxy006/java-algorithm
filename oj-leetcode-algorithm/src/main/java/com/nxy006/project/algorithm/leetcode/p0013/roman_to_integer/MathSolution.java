package com.nxy006.project.algorithm.leetcode.p0013.roman_to_integer;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数学解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  10 ms   , beats 18.54 % of java submissions.
 * Memory   39.7 MB , beats 28.45 % of java submissions.
 * 07/22/2021 23:37
 */
public class MathSolution {
    private final int[]    nums   =    new int[]{1,   4,    5,   9,    10,  40,   50,  90,   100, 400,  500, 900,  1000};
    private final String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    private final Map<String, Integer> romanMap = new HashMap<>();

    public int romanToInt(String s) {
        // Init Map
        for(int i = 0; i < romans.length; i++) {
            romanMap.put(romans[i], nums[i]);
        }

        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            String str= s.charAt(i) + "";;
            if (i < s.length()-1 && isMatch(s.charAt(i), s.charAt(i+1))) {
                str = s.substring(i, i+2);
                i++;
            }

            num += romanMap.get(str);
        }
        return num;
    }

    private boolean isMatch(char a, char b) {
        return a == 'I' && (b == 'V' || b == 'X') || a == 'X' && (b == 'L' || b == 'C') || a == 'C' && (b == 'D' || b == 'M');
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(3, new MathSolution().romanToInt("III"));
        CaseAssertUtils.assertEquals(4, new MathSolution().romanToInt("IV"));
        CaseAssertUtils.assertEquals(9, new MathSolution().romanToInt("IX"));
        CaseAssertUtils.assertEquals(58, new MathSolution().romanToInt("LVIII"));
        CaseAssertUtils.assertEquals(1994, new MathSolution().romanToInt("MCMXCIV"));
    }
}
