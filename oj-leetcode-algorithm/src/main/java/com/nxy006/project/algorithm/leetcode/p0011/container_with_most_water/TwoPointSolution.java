package com.nxy006.project.algorithm.leetcode.p0011.container_with_most_water;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * TODO 待提交测试
 */
public class TwoPointSolution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, minHeight = Integer.min(height[l], height[r]), res = (r-l)*minHeight;
        while(l < r) {
            int currMinHeight = Integer.min(height[l], height[r]);
            if (currMinHeight > minHeight) {
                minHeight = currMinHeight;
                res = Integer.max(res, (r-l) * currMinHeight);
            }

            if (height[l] == currMinHeight) l++;
            if (height[r] == currMinHeight) r--;
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new TwoPointSolution(), 49, "[1,8,6,2,5,4,8,3,7]");
        caseCheck(new TwoPointSolution(), 1, "[1,1]");
        caseCheck(new TwoPointSolution(), 16, "[4,3,2,1,4]");
        caseCheck(new TwoPointSolution(), 2, "[1,2,1]");
    }

    private static void caseCheck(TwoPointSolution solution, int expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.maxArea(StructConvertUtils.convertToIntArray(s)));
    }
}
