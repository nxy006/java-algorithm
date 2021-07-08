package com.nxy006.project.algorithm.leetcode.p0012.integer_to_roman;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    int[] nums      = new int[]{   1,   4,    5,   9,    10,  50,  90,   100, 500, 900,  1000};
    String[] romans = new String[]{"I", "IV", "V", "IX", "X", "L", "XC", "C", "D", "CM", "M"};

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
        CaseAssertUtils.assertEquals("III", new Solution().intToRoman(3));
        CaseAssertUtils.assertEquals("IV", new Solution().intToRoman(4));
        CaseAssertUtils.assertEquals("IX", new Solution().intToRoman(9));
        CaseAssertUtils.assertEquals("LVIII", new Solution().intToRoman(58));
        CaseAssertUtils.assertEquals("MCMXCIV", new Solution().intToRoman(1994));
    }
}
