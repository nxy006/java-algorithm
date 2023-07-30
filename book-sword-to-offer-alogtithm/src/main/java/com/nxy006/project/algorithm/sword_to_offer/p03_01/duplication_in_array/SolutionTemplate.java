package com.nxy006.project.algorithm.sword_to_offer.p03_01.duplication_in_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题3（一）：找出数组中重复的数字
 * <p>
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 *      也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 *      那么对应的输出是重复的数字2或者3。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/blob/master/03_01_DuplicationInArray">gitHub</a>
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
    }

    public static void caseCheck(SolutionTemplate solution, String expected, String arrStr) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToIntArray(expected),
                solution.findRepeatNumber(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
