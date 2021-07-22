package com.nxy006.project.algorithm.leetcode.p0013.roman_to_integer;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 待提交测试
 */
public class Solution {
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
        CaseAssertUtils.assertEquals(3, new Solution().romanToInt("III"));
        CaseAssertUtils.assertEquals(4, new Solution().romanToInt("IV"));
        CaseAssertUtils.assertEquals(9, new Solution().romanToInt("IX"));
        CaseAssertUtils.assertEquals(58, new Solution().romanToInt("LVIII"));
        CaseAssertUtils.assertEquals(1994, new Solution().romanToInt("MCMXCIV"));
    }
}
