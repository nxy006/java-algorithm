package com.nxy006.project.algorithm.leetcode.p0033.search_in_rotated_sorted_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 二分解法
 * 时间复杂度：O(log_n)，空间复杂度：O(1)
 *
 * Runtime  0 ms  , beats 100.00 % of java submissions.
 * Memory   38 MB , beats  92.26 % of java submissions.
 * 08/03/2021 22:30
 */
public class BinarySearchSolution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), 4,"[4,5,6,7,0,1,2]", 0);
        caseCheck(new BinarySearchSolution(), -1,"[4,5,6,7,0,1,2]", 3);
        caseCheck(new BinarySearchSolution(), -1,"[1]", 0);
        // 自定义用例
        caseCheck(new BinarySearchSolution(), 3,"[5,6,7,0,1,2,4]", 0);
        caseCheck(new BinarySearchSolution(), 2,"[6,7,0,1,2,4,5]", 0);
        caseCheck(new BinarySearchSolution(), 4,"[2,4,6,7,0,1]", 0);
        caseCheck(new BinarySearchSolution(), 3,"[4,6,7,0,1,2]", 0);
        caseCheck(new BinarySearchSolution(), 2,"[6,7,0,1,2,4]", 0);
        caseCheck(new BinarySearchSolution(), 1,"[6,7,0,1,2,4,5]", 7);
        caseCheck(new BinarySearchSolution(), 3,"[6,7,0,1,2,4,5]", 1);
        caseCheck(new BinarySearchSolution(), 4,"[6,7,0,1,2,4,5]", 2);
    }

    private static void caseCheck(BinarySearchSolution solution, int expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(expected, solution.search(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
