package com.nxy006.project.algorithm.leetcode.p0014.longest_common_prefix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 垂直扫描解法
 * 时间复杂度：O(S)，空间复杂度：O(1)，其中 S 为所有输入的字符总量
 *
 * Runtime  2 ms    , beats 33.98 % of java submissions.
 * Memory   38.5 MB , beats 34.15 % of java submissions.
 * 07/09/2021 00:18
 */
public class VerticalScanningSolution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (strs[0].length() > i) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() <= i || str.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals("fl", new VerticalScanningSolution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"flower\",\"flow\",\"flight\"]")));
        CaseAssertUtils.assertEquals("", new VerticalScanningSolution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"dog\",\"racecar\",\"car\"]")));
        CaseAssertUtils.assertEquals("flower", new VerticalScanningSolution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"flower\",\"flower\"]")));
    }
}
