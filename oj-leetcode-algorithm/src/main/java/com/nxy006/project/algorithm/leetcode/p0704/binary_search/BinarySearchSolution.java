package com.nxy006.project.algorithm.leetcode.p0704.binary_search;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 二分解法
 * 时间复杂度：O(log_n)，空间复杂度：O(1)
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   43 MB , beats  86.13 % of java submissions.
 * 03/26/2022 12:18
 */
public class BinarySearchSolution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), 4,"[-1,0,3,5,9,12]", 9);
        caseCheck(new BinarySearchSolution(), -1,"[-1,0,3,5,9,12]", 2);
    }

    private static void caseCheck(BinarySearchSolution solution, int expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(expected, solution.search(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
