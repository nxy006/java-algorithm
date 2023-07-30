package com.nxy006.project.algorithm.sword_to_offer.p03_02.duplication_in_array_no_edit;

import com.nxy006.project.algorithm.sword_to_offer.p03_01.duplication_in_array.Solution;
import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 *  * 面试题3（二）：不修改数组找出重复的数字
 * <p>
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 *      数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/tree/master/03_02_DuplicationInArrayNoEdit">gitHub</a>
 * <p/>
 */
public class SolutionTemplate {
    public int findRepeatNumber(int[] nums) {
        throw new RuntimeException("未实现的方法");
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new SolutionTemplate());
    }

    public static void processCaseTest(SolutionTemplate solution) {
        // Leetcode-CN 题目示例
        caseCheck(solution, "[2,3]", "[2,3,1,0,2,5,3]");
        // 书籍用例（省略用例5. 异常数据；用例6. 传入 null）
        caseCheck(solution, "[1]", "[2,1,3,1,4]");            // 1. 重复的数字是数组中最小的数字
        caseCheck(solution, "[4]", "[2,4,3,1,4]");            // 2. 重复的数字是数组中最大的数字
        caseCheck(solution, "[2,4]", "[2,1,2,1,4]");          // 3. 数组中存在多个重复的数字
        caseCheck(solution, "[-1]", "[2,1,3,0,4]");           // 4. 没有重复的数字
        // Leetcode-CN 失败用例
        caseCheck(solution, "[0]", "[0,1,2,0,4,5,6,7,8,9]");
    }

    public static void caseCheck(SolutionTemplate solution, String expected, String arrStr) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToIntArray(expected),
                solution.findRepeatNumber(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
