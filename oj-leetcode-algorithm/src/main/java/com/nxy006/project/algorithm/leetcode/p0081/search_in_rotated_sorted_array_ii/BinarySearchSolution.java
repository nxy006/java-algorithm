package com.nxy006.project.algorithm.leetcode.p0081.search_in_rotated_sorted_array_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class BinarySearchSolution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[l] < nums[mid]) {
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
        return false;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), true,"[2,5,6,0,0,1,2]", 0);
        caseCheck(new BinarySearchSolution(), false,"[2,5,6,0,0,1,2]", 3);
        // 自定义用例
        caseCheck(new BinarySearchSolution(), true,"[5,6,7,0,1,2,4]", 0);
        caseCheck(new BinarySearchSolution(), true,"[6,7,0,1,2,4,5]", 0);
        caseCheck(new BinarySearchSolution(), true,"[2,4,6,7,0,1]", 0);
        caseCheck(new BinarySearchSolution(), true,"[4,6,7,0,1,2]", 0);
        caseCheck(new BinarySearchSolution(), true,"[6,7,0,1,2,4]", 0);
        caseCheck(new BinarySearchSolution(), true,"[6,7,0,1,2,4,5]", 7);
        caseCheck(new BinarySearchSolution(), true,"[6,7,0,1,2,4,5]", 1);
        caseCheck(new BinarySearchSolution(), true,"[6,7,0,1,2,4,5]", 2);
    }

    private static void caseCheck(BinarySearchSolution solution, boolean expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(expected, solution.search(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
