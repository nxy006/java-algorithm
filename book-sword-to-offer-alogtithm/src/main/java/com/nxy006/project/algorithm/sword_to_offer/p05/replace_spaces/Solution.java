package com.nxy006.project.algorithm.sword_to_offer.p05.replace_spaces;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 *       则输出“We%20are%20happy.”。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/05_ReplaceSpaces
 *
 * 注：这道题实际是 C 语言题目，考察做 char[] 操作，强调替换时从后向前替换，避免多次移动字符串数据。
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了  18.36 % 的用户
 * 2021/08/09 18:19
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // Leetcode-CN 题目示例
        CaseAssertUtils.assertEquals("We%20are%20happy.", new Solution().replaceSpace("We are happy."));
        // 书籍用例（省略用例5. 传入 null）
        CaseAssertUtils.assertEquals("hello%20world", new Solution().replaceSpace("hello world"));      // 1. 空格在句子中间
        CaseAssertUtils.assertEquals("%20helloworld", new Solution().replaceSpace(" helloworld"));      // 2. 空格在句子开头
        CaseAssertUtils.assertEquals("helloworld%20", new Solution().replaceSpace("helloworld "));      // 3. 空格在句子末尾
        CaseAssertUtils.assertEquals("hello%20%20world", new Solution().replaceSpace("hello  world"));  // 4. 连续有两个空格
        CaseAssertUtils.assertEquals("", new Solution().replaceSpace(""));                              // 6. 传入内容为空的字符串
        CaseAssertUtils.assertEquals("%20", new Solution().replaceSpace(" "));                          // 7. 传入内容为一个空格的字符串
        CaseAssertUtils.assertEquals("helloworld", new Solution().replaceSpace("helloworld"));          // 8. 传入的字符串没有空格
        CaseAssertUtils.assertEquals("%20%20%20", new Solution().replaceSpace("   "));                  // 9. 传入的字符串全是空格
    }
}
