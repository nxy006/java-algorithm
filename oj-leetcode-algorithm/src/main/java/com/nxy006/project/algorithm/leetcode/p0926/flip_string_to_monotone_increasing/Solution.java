package com.nxy006.project.algorithm.leetcode.p0926.flip_string_to_monotone_increasing;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int zeroCount = 0, oneCount = 0;
        for(char c : s.toCharArray()) {
            if (c == '0') {
                oneCount++;
            } else {
                oneCount = Integer.min(oneCount, zeroCount);
                zeroCount++;
            }
        }
        return Integer.min(oneCount, zeroCount);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(1, new Solution().minFlipsMonoIncr("00110"));
        CaseAssertUtils.assertEquals(2, new Solution().minFlipsMonoIncr("010110"));
        CaseAssertUtils.assertEquals(2, new Solution().minFlipsMonoIncr("00011000"));
        // 自定义用例
        CaseAssertUtils.assertEquals(0, new Solution().minFlipsMonoIncr("1111111111111111"));
        CaseAssertUtils.assertEquals(0, new Solution().minFlipsMonoIncr("000000000000000000"));
        CaseAssertUtils.assertEquals(5, new Solution().minFlipsMonoIncr("11111100000"));
        CaseAssertUtils.assertEquals(8, new Solution().minFlipsMonoIncr("1010101010101010"));
        CaseAssertUtils.assertEquals(5, new Solution().minFlipsMonoIncr("01010101010"));
        CaseAssertUtils.assertEquals(1, new Solution().minFlipsMonoIncr("00000010000000000000"));
    }
}
