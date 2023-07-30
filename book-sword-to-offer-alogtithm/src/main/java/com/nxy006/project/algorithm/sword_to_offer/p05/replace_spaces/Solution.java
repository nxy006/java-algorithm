package com.nxy006.project.algorithm.sword_to_offer.p05.replace_spaces;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题5：替换空格
 * <p>
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 *      则输出“We%20are%20happy.”。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/tree/master/05_ReplaceSpaces">gitHub</a><br/>
 * (注：这道题实际是 C 语言题目，考察做 char[] 操作，强调替换时从后向前替换，避免多次移动字符串数据。)
 * <p/>
 *
 * <p>
 * LeetCode-CN 解答：<br/>
 * - Link：<a href="https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/">leetcode-cn</a><br/>
 * - 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户<br/>
 * - 内存消耗：36.4 MB, 在所有 Java 提交中击败了  18.36 % 的用户<br/>
 * - 2021/08/09 18:19
 * <p/>

 */
public class Solution extends SolutionTemplate {
    @Override
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SolutionTemplate.processCaseTest(new Solution());
    }
}
