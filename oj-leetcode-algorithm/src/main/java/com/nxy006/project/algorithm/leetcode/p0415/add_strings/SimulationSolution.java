package com.nxy006.project.algorithm.leetcode.p0415.add_strings;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * 模拟解法
 * 时间复杂度：O(max(len1, len2))，空间复杂度：O(1)
 *
 * Runtime  3 ms  , beats 42.22 % of java submissions.
 * Memory   39 MB , beats 59.75 % of java submissions.
 * 08/10/2021 02:15
 */
public class SimulationSolution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0".equals(num1) ? num2 : num1;
        }

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int num =
                    (i >= 0 ? (num1.charAt(i--) - '0') : 0) +
                            (j >= 0 ? (num2.charAt(j--) - '0') : 0) +
                            carry;
            sb.insert(0, num % 10);
            carry = num / 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("134", new SimulationSolution().addStrings("11", "123"));
        CaseAssertUtils.assertEquals("533", new SimulationSolution().addStrings("456", "77"));
        CaseAssertUtils.assertEquals("0", new SimulationSolution().addStrings("0", "0"));
        // 自定义用例
        CaseAssertUtils.assertEquals("1000", new SimulationSolution().addStrings("999", "1"));
        CaseAssertUtils.assertEquals("1998", new SimulationSolution().addStrings("999", "999"));
        CaseAssertUtils.assertEquals("999", new SimulationSolution().addStrings("998", "1"));
    }
}
