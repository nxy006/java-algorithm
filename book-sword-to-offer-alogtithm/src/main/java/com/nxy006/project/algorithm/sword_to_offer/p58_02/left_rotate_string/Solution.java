package com.nxy006.project.algorithm.sword_to_offer.p58_02.left_rotate_string;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题58（二）：左旋转字符串
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *       请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
 *       字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/58_02_LeftRotateString
 *
 * TODO 未完成解答
 *
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/submissions/451583792/?envType=study-plan-v2&envId=coding-interviews
 * 时间
 * 详情
 * -ms
 * 击败 100.00%使用 Java 的用户
 * 内存
 * 详情
 * 40.12mb
 * 击败 92.60%使用 Java 的用户
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        if (s == null || n == 0 || s.length() == n) {
            return s;
        }

        n = n % s.length();
        return s.substring(n) + s.substring(0, n);
    }
}
