package com.nxy006.project.algorithm.leetcode.p0014.longest_common_prefix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
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
        CaseAssertUtils.assertEquals("fl", new Solution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"flower\",\"flow\",\"flight\"]")));
        CaseAssertUtils.assertEquals("", new Solution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"dog\",\"racecar\",\"car\"]")));
        CaseAssertUtils.assertEquals("flower", new Solution().longestCommonPrefix(StructConvertUtils.convertToStringArray("[\"flower\",\"flower\"]")));
    }
}
