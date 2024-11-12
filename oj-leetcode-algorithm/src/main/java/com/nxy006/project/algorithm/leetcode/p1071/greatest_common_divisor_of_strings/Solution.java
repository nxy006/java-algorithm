package com.nxy006.project.algorithm.leetcode.p1071.greatest_common_divisor_of_strings;

/**
 * 模拟
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  4 ms    , beats 11.53 % of java submissions.
 * Memory   44.73 MB, beats  8.13 % of java submissions.
 * 12/11/2024 19:03
 */
public class Solution extends SolutionTemplate {
    public String gcdOfStrings(String str1, String str2) {
        int maxCommonLength = 0;
        for(int i = 0; i < str1.length(); i++) {
            if (i >= str2.length() || str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            maxCommonLength = i + 1;
        }

        if (maxCommonLength == 0) {
            return "";
        }

        for(int i = maxCommonLength; i > 0; i--) {
            String x = str1.substring(0, i);
            if (isCanDivide(str1, x) && isCanDivide(str2, x)) {
                return x;
            }
        }
        return "";
    }

    private boolean isCanDivide(String s, String x) {
        if (s.length() % x.length() != 0) {
            return false;
        }

        for(int i = x.length(); i < s.length(); i++) {
            if (s.charAt(i) != x.charAt(i % x.length())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
