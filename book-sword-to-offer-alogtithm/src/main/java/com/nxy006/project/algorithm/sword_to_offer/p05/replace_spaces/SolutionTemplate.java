package com.nxy006.project.algorithm.sword_to_offer.p05.replace_spaces;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.KlassUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题5：替换空格
 * <p>
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 *      则输出“We%20are%20happy.”。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/tree/master/05_ReplaceSpaces">gitHub</a><br/>
 * (注：这道题实际是 C 语言题目，考察做 char[] 操作，强调替换时从后向前替换，避免多次移动字符串数据。)
 * <p/>
 */
public abstract class SolutionTemplate {
    abstract public String replaceSpace(String s);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(SolutionTemplate.class);
    }

    public static <T> void processCaseTest(Class<T> klass) {
        // Leetcode-CN 题目示例
        CaseAssertUtils.assertEquals("We%20are%20happy.", createSolution(klass).replaceSpace("We are happy."));
        // 书籍用例（省略用例5. 传入 null）
        CaseAssertUtils.assertEquals("hello%20world", createSolution(klass).replaceSpace("hello world"));      // 1. 空格在句子中间
        CaseAssertUtils.assertEquals("%20helloworld", createSolution(klass).replaceSpace(" helloworld"));      // 2. 空格在句子开头
        CaseAssertUtils.assertEquals("helloworld%20", createSolution(klass).replaceSpace("helloworld "));      // 3. 空格在句子末尾
        CaseAssertUtils.assertEquals("hello%20%20world", createSolution(klass).replaceSpace("hello  world"));  // 4. 连续有两个空格
        CaseAssertUtils.assertEquals("", createSolution(klass).replaceSpace(""));                              // 6. 传入内容为空的字符串
        CaseAssertUtils.assertEquals("%20", createSolution(klass).replaceSpace(" "));                          // 7. 传入内容为一个空格的字符串
        CaseAssertUtils.assertEquals("helloworld", createSolution(klass).replaceSpace("helloworld"));          // 8. 传入的字符串没有空格
        CaseAssertUtils.assertEquals("%20%20%20", createSolution(klass).replaceSpace("   "));                  // 9. 传入的字符串全是空格
    }

    private static <T> SolutionTemplate createSolution(Class<T> klass) {
        return (SolutionTemplate) KlassUtils.createInstance(klass);
    }
}
