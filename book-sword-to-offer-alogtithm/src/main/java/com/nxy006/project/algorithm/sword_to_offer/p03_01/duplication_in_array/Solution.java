package com.nxy006.project.algorithm.sword_to_offer.p03_01.duplication_in_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 *       也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 *       那么对应的输出是重复的数字2或者3。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/blob/master/03_01_DuplicationInArray
 *
 * 常规做法是使用 Set 或排序，但本题给定了数据返回是 0-n-1，与数据下标吻合，因而可以用下标保存该值是否出现过，交换数字的位置即可
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * LeetCode-CN 解答：
 * Link：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户
 * 内存消耗：46.1 MB, 在所有 Java 提交中击败了  70.35 % 的用户
 * 2021/08/10 22:02
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; ) {
            // 已经在正确的位置，处理下一个
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            // 注意交换时 temp 变量的使用
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // Leetcode-CN 题目示例
        caseCheck(new Solution(), "[2,3]", "[2,3,1,0,2,5,3]");
        // 书籍用例（省略用例5. 异常数据；用例6. 传入 null）
        caseCheck(new Solution(), "[1]", "[2,1,3,1,4]");            // 1. 重复的数字是数组中最小的数字
        caseCheck(new Solution(), "[4]", "[2,4,3,1,4]");            // 2. 重复的数字是数组中最大的数字
        caseCheck(new Solution(), "[2,4]", "[2,1,2,1,4]");          // 3. 数组中存在多个重复的数字
        caseCheck(new Solution(), "[-1]", "[2,1,3,0,4]");           // 4. 没有重复的数字
    }

    private static void caseCheck(Solution solution, String expected, String arrStr) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToIntArray(expected),
                new Solution().findRepeatNumber(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
