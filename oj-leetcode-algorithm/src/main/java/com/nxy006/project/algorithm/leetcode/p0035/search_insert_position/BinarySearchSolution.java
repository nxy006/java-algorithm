package com.nxy006.project.algorithm.leetcode.p0035.search_insert_position;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class BinarySearchSolution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;

        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BinarySearchSolution(), 2,"[1,3,5,6]", 5);
        caseCheck(new BinarySearchSolution(), 1,"[1,3,5,6]", 2);
        caseCheck(new BinarySearchSolution(), 4,"[1,3,5,6]", 7);
        caseCheck(new BinarySearchSolution(), 0,"[1,3,5,6]", 0);
        caseCheck(new BinarySearchSolution(), 0,"[1]", 0);
        // 自定义用例
        caseCheck(new BinarySearchSolution(), 2,"[1,3,5,6]", 4);
        caseCheck(new BinarySearchSolution(), 3,"[1,2,3,5,6]", 4);
        caseCheck(new BinarySearchSolution(), 2,"[1,6,8,10,12]", 7);
    }

    private static void caseCheck(BinarySearchSolution solution, int expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(expected, solution.searchInsert(StructConvertUtils.convertToIntArray(numsStr), target));
    }
}
