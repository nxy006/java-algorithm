package com.nxy006.project.algorithm.leetcode.p0162.find_peak_element;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class BinarySearchSolution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if ((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            } else if (mid < nums.length-1 && nums[mid] < nums[mid+1]) {
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
        caseCheck(new BinarySearchSolution(), "[2]", "[1,2,3,1]");
        caseCheck(new BinarySearchSolution(), "[1,3,5]", "[1,2,1,3,5,6,4]");
        // 自定义用例
        caseCheck(new BinarySearchSolution(), "[4]", "[1,2,3,4,5]");
        caseCheck(new BinarySearchSolution(), "[0]", "[5,4,3,2,1]");
        caseCheck(new BinarySearchSolution(), "[0]", "[5,3,2,1,4]");
    }

    private static void caseCheck(BinarySearchSolution solution, String expected, String numsStr) {
        CaseAssertUtils.assertContains(StructConvertUtils.convertToIntArray(expected), solution.findPeakElement(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
