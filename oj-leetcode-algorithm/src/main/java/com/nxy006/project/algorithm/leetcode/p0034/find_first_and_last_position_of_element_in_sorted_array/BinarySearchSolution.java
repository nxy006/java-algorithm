package com.nxy006.project.algorithm.leetcode.p0034.find_first_and_last_position_of_element_in_sorted_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class BinarySearchSolution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1, lRes = -1, rRes = -1;
        while(l <= r) {
            int mid = (r+l)/2;
            if (nums[mid] == target && (mid == 0 || nums[mid-1] != target)) {
                lRes = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        l = 0;
        r = nums.length-1;
        while(l <= r) {
            int mid = (r+l)/2;
            if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] != target)) {
                rRes = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return new int[]{lRes, rRes};
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), "[3,4]","[5,7,7,8,8,10]", 8);
        caseCheck(new BinarySearchSolution(), "[-1,-1]","[5,7,7,8,8,10]", 6);
        caseCheck(new BinarySearchSolution(), "[-1,-1]","[]", 0);
        // 自定义用例
        caseCheck(new BinarySearchSolution(), "[3,3]","[5,7,7,8,9,10]", 8);
        caseCheck(new BinarySearchSolution(), "[2,2]","[5,7,8,9,10]", 8);
        caseCheck(new BinarySearchSolution(), "[0,3]","[5,5,5,5,6]", 5);
        caseCheck(new BinarySearchSolution(), "[1,4]","[4,5,5,5,5]", 5);
        caseCheck(new BinarySearchSolution(), "[0,4]","[5,5,5,5,5]", 5);
    }

    private static void caseCheck(BinarySearchSolution solution, String expectedStr, String numsStr, int target) {
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expectedStr), solution.searchRange(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
