package com.nxy006.project.algorithm.leetcode.p0091.decode_ways;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * TODO 待提交测试
 */
public class Solution {
    private int[] res;
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        this.res = new int[s.length()];
        Arrays.fill(res, -1);
        return process(s.toCharArray(), s.length()-1);
    }

    private int process(char[] arr, int i) {
        if (i < 0) return 1;
        if (res[i] != -1) return res[i];

        int cnt = 0;
        if ('1' <= arr[i] && arr[i] <= '9') {
            cnt += process(arr, i-1);
        }
        if (i >= 1 && (arr[i-1] == '2' && ('0' <= arr[i] && arr[i] <= '9') || arr[i-1] == '1' && ('0' <= arr[i] && arr[i] <= '9'))) {
            cnt += process(arr, i-2);
        }
        return res[i] = cnt;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(2, new Solution().numDecodings("12"));
        CaseAssertUtils.assertEquals(3, new Solution().numDecodings("226"));
        CaseAssertUtils.assertEquals(0, new Solution().numDecodings("0"));
        CaseAssertUtils.assertEquals(0, new Solution().numDecodings("06"));
        // 自定义用例
        CaseAssertUtils.assertEquals(1, new Solution().numDecodings("9999999999"));
        CaseAssertUtils.assertEquals(2, new Solution().numDecodings("9999999919"));
    }
}
