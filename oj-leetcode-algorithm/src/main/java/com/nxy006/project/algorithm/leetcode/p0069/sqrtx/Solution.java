package com.nxy006.project.algorithm.leetcode.p0069.sqrtx;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * TODO 待提交测试
 */
public class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (mid*mid <= x && x < (mid+1)*(mid+1)) {
                return mid;
            } else if (mid*mid > x) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(2, new Solution().mySqrt(4));
        CaseAssertUtils.assertEquals(2, new Solution().mySqrt(8));
        // 自定义用例
        CaseAssertUtils.assertEquals(0, new Solution().mySqrt(0));
        CaseAssertUtils.assertEquals(1, new Solution().mySqrt(1));
        CaseAssertUtils.assertEquals(3, new Solution().mySqrt(15));
        CaseAssertUtils.assertEquals(4, new Solution().mySqrt(16));
        CaseAssertUtils.assertEquals(4, new Solution().mySqrt(17));
        CaseAssertUtils.assertEquals(4, new Solution().mySqrt(18));
        CaseAssertUtils.assertEquals(4, new Solution().mySqrt(24));
        CaseAssertUtils.assertEquals(5, new Solution().mySqrt(25));
    }
}
