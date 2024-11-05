package com.nxy006.project.algorithm.sword_to_offer.p20.numeric_strings;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 *       字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 *       “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/20_NumericStrings
 *
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 *
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/submissions/451593604
 * 时间
 * 详情
 * 10ms
 * 击败 9.11%使用 Java 的用户
 * 内存
 * 详情
 * 41.65mb
 * 击败 20.33%使用 Java 的用户
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        s = s.trim().replaceFirst("(e|E)", "|");
        String[] arr = s.split("\\|");
        switch(arr.length) {
            case 1: return isIntOrPoint(s);
            case 2: return isIntOrPoint(arr[0]) && isInt(arr[1]);
            default: return false;
        }
    }

    private boolean isPoint(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean isPointShowed = false, isBeforePointShowed = false, isAfterPointShowed = false;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '+' || c == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (c == '.') {
                if (isPointShowed) {
                    return false;
                }
                isPointShowed = true;
            } else if (c >= '0' && c <= '9') {
                if (isPointShowed) {
                    isAfterPointShowed = true;
                } else {
                    isBeforePointShowed = true;
                }
            } else {
                return false;
            }
        }

        return isPointShowed && (isBeforePointShowed || isAfterPointShowed);
    }

    private boolean isInt(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean isNumberShowed = false;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '+' || c == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                isNumberShowed = true;
            } else {
                return false;
            }
        }

        return isNumberShowed;
    }

    private boolean isIntOrPoint(String s) {
        return isInt(s) || isPoint(s);
    }

    public static void main(String[] args) {
        // 失败一次，7e69e
        System.out.println(new Solution().isNumber("7e69e"));
    }
}
