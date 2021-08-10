package com.nxy006.project.algorithm.sword_to_offer.p03_02.duplication_in_array_no_edit;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题3（二）：不修改数组找出重复的数字
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 *       少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 *       数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 *       输出是重复的数字2或者3。
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/03_02_DuplicationInArrayNoEdit
 *
 * 本题只要求定性，找到任一解答，因而本算法提出了一种思路，用二分的方式，每次检查一半范围内的数量是否超过了正常数量，逐个缩小范围
 * 不过，这个算法是不完全正确的，如果 [1,2] 取值范围内有三个数，那么必然存在重复数，但如果有两个数，并不能表示有或没有重复数字
 *
 * LeetCode-CN 解答：解答错误（该算法不能通过用例）
 * Link：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r-l)/2, cnt = 0;
            for(int num : nums) {
                if (num >= l && num <= mid) {
                    cnt++;
                }
            }

            if (l == r && cnt > 1) {
                return l;
            }

            if (cnt > mid-l+1) {
                r = mid;
            } else {
                l = mid + 1;
            }
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
        // Leetcode-CN 失败用例
        caseCheck(new Solution(), "[0]", "[0,1,2,0,4,5,6,7,8,9]");
    }

    private static void caseCheck(Solution solution, String expected, String arrStr) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToIntArray(expected),
                solution.findRepeatNumber(StructConvertUtils.convertToIntArray(arrStr)));
    }
}
