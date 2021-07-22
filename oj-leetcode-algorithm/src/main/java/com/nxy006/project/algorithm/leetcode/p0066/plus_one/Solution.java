package com.nxy006.project.algorithm.leetcode.p0066.plus_one;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 常规解法
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   37.8 MB , beats  23.22 % of java submissions.
 * 07/22/2021 23:44
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            int num = digits[i] + carry;
            digits[i] = num % 10;
            carry = num / 10;
        }
        if (carry != 0) {
            int[] ans = new int[digits.length+1];
            ans[0] = carry;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        } else {
            return digits;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,4]", "[1,2,3]");
        caseCheck(new Solution(), "[4,3,2,2]", "[4,3,2,1]");
        caseCheck(new Solution(), "[1]", "[0]");
        // 自定义用例
        caseCheck(new Solution(), "[1,0,0,0]", "[9,9,9]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String numsStr) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expectedStr), solution.plusOne(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
