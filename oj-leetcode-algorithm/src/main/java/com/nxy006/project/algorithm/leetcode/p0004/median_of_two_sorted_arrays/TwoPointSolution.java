package com.nxy006.project.algorithm.leetcode.p0004.median_of_two_sorted_arrays;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 双指针扫描遍历
 * 时间复杂度：O(n+m)，空间复杂度：O(1)
 *
 * Runtime  2 ms    , beats 99.88 % of java submissions.
 * Memory   40.3 MB , beats 40.07 % of java submissions.
 * 07/06/2021 14:26
 */
public class TwoPointSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, mid = (n+m)/2 - ((n+m)%2==0 ? 1 : 0);

        double res = 0;
        int i = 0, j = 0;
        for(int t = 0; t <= (n+m)/2; t++) {             // 只遍历前半 + 中间部分
            int current = (i < n && (j >= m || nums1[i] <= nums2[j])) ? nums1[i++] : nums2[j++];;

            if (t >= mid) {                             // 超过中间值位置则开始加和
                res += current * 1.0;
            }
        }
        return (n+m) % 2 == 1 ? res : res / 2;
    }


    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new TwoPointSolution(), 2.00000, "[1,3]","[2]");
        caseCheck(new TwoPointSolution(), 2.50000, "[1,2]","[3,4]");
        caseCheck(new TwoPointSolution(), 0.00000, "[0,0]","[0,0]");
        caseCheck(new TwoPointSolution(), 1.00000, "[]","[1]");
        caseCheck(new TwoPointSolution(), 2.00000, "[2]","[]");
    }

    private static void caseCheck(TwoPointSolution solution, double expected, String nums1Str, String nums2Str) {
        CaseAssertUtils.assertEquals(expected, solution.findMedianSortedArrays(StructConvertUtils.convertToIntArray(nums1Str), StructConvertUtils.convertToIntArray(nums2Str)));
    }

}
