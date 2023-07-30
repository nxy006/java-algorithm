package com.nxy006.project.algorithm.sword_to_offer.p03_02.duplication_in_array_no_edit;

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
 *
 * <hr/>
 *  本题只要求定性，找到任一解答，因而本算法提出了一种思路，用二分的方式，每次检查一半范围内的数量是否超过了正常数量，逐个缩小范围。
 *  不过，这个算法是不完全正确的，如果 [1,2] 取值范围内有三个数，那么必然存在重复数，但如果有两个数，并不能表示有或没有重复数字<br/>
 *  时间复杂度：O(nlogn)，空间复杂度：O(1)
 *
 * <p>
 * LeetCode-CN 解答：<br/>
 * - Link：<a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof//">leetcode-cn</a><br/>
 * - 执行用时：0 ms,    在所有 Java 提交中击败了 100.00 % 的用户<br/>
 * - 内存消耗：46.1 MB, 在所有 Java 提交中击败了  70.35 % 的用户<br/>
 * - 2021/08/10 22:02
 * <p/>
 */
public class Solution extends SolutionTemplate {
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

    public static void main(String[] args) {
        SolutionTemplate.processCaseTest(new Solution());
    }
}
