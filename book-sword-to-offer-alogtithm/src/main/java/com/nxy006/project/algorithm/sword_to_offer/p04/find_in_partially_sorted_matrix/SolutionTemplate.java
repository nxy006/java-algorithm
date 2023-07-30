package com.nxy006.project.algorithm.sword_to_offer.p04.find_in_partially_sorted_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》<br/>
 * 面试题4：二维数组中的查找
 * <p>
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。<br/>
 * 官解：<a href="https://github.com/zhedahht/CodingInterviewChinese2/tree/master/04_FindInPartiallySortedMatrix">gitHub</a>
 * <p/>
 */
public class SolutionTemplate {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        throw new RuntimeException("未实现的方法");
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new SolutionTemplate());
    }

    public static void processCaseTest(SolutionTemplate solution) {
        // Leetcode-CN 题目示例
        caseCheck(solution, true, "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]", 5);
        // 书籍用例（省略用例7. 鲁棒性测试，输入空指针）
        caseCheck(solution, true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 7);       // 1. 要查找的数在数组中
        caseCheck(solution, false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 5);      // 2. 要查找的数不在数组中
        caseCheck(solution, true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 1);       // 3. 要查找的数是数组中最小的数字
        caseCheck(solution, true, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 15);      // 4. 要查找的数在数组中
        caseCheck(solution, false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 0);      // 5. 要查找的数比数组中最小的数字还小
        caseCheck(solution, false, "[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]", 16);     // 6. 要查找的数比数组中最大的数字还大
    }

    public static void caseCheck(SolutionTemplate solution, boolean expected, String matrixStr, int target) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.findNumberIn2DArray(StructConvertUtils.convertToIntMatrix(matrixStr), target));
    }
}
