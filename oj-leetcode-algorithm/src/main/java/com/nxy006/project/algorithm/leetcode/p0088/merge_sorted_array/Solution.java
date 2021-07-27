package com.nxy006.project.algorithm.leetcode.p0088.merge_sorted_array;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return ;

        int i = m+n-1;
        m--;
        n--;
        while(i >= 0) {
            if (n < 0 || m >= 0 && nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[1,2,2,3,5,6]", "[1,2,3,0,0,0]", 3, "[2,5,6]", 3);
        caseCheck(new Solution(), "[1]", "[1]", 1, "[]", 0);
        caseCheck(new Solution(), "[1]", "[0]", 0, "[1]", 1);
    }

    private static void caseCheck(Solution solution, String expected, String nums1Str, int m, String nums2Str, int n) {
        int[] nums1 = StructConvertUtils.convertToIntArray(nums1Str), nums2 = StructConvertUtils.convertToIntArray(nums2Str);
        solution.merge(nums1, m, nums2, n);
        CaseAssertUtils.assertEquals(StructConvertUtils.convertToIntArray(expected), nums1);
    }
}
