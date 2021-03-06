package com.nxy006.project.algorithm.leetcode.p0042.trapping_rain_water;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 两轮遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  1 ms    , beats 85.40 % of java submissions.
 * Memory   38.9 MB , beats 25.56 % of java submissions.
 * 07/15/2021 23:16
 */
public class TwoPassSolution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int[] lHeigths = new int[height.length];
        lHeigths[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            lHeigths[i] = Integer.max(lHeigths[i-1], height[i]);
        }
        int ans = 0, rHeight = height[height.length-1];
        for(int i = height.length-1; i >= 0; i--) {
            rHeight = Integer.max(rHeight, height[i]);
            ans += Integer.min(lHeigths[i], rHeight) - height[i];
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPassSolution(), 6, "[0,1,0,2,1,0,1,3,2,1,2,1]");
        caseCheck(new TwoPassSolution(), 9, "[4,2,0,3,2,5]");
        // 自定义用例
        caseCheck(new TwoPassSolution(), 0, "[3,3,3,3,3,3,3,3]");
        caseCheck(new TwoPassSolution(), 0, "[3,4,5,4,3]");
        caseCheck(new TwoPassSolution(), 1, "[2,2,2,1,2,2,2]");
    }

    private static void caseCheck(TwoPassSolution solution, int expected, String numsStr) {
        CaseAssertUtils.assertEquals(expected, solution.trap(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
