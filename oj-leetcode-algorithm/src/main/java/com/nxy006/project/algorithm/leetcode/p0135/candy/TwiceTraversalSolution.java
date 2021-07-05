package com.nxy006.project.algorithm.leetcode.p0135.candy;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * 两轮遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  4 ms    , beats 30.88 % of java submissions.
 * Memory   40.2 MB , beats 50.79 % of java submissions.
 * 06/28/2021 23:26
 */
public class TwiceTraversalSolution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // 正序遍历
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        // 倒序遍历
        for(int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Integer.max(candies[i], candies[i+1] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(5, new TwiceTraversalSolution().candy(new int[]{1, 0, 2}));
        CaseAssertUtils.assertEquals(4, new TwiceTraversalSolution().candy(new int[]{1, 2, 2}));
        CaseAssertUtils.assertEquals(12, new TwiceTraversalSolution().candy(new int[]{1, 3, 3, 3, 3, 3, 2, 1}));
        CaseAssertUtils.assertEquals(18, new TwiceTraversalSolution().candy(new int[]{3, 2, 1, 1, 3, 2, 1, 2, 5}));
        CaseAssertUtils.assertEquals(8, new TwiceTraversalSolution().candy(new int[]{100, 100, 100, 100, 100, 100, 100, 100}));
        CaseAssertUtils.assertEquals(20, new TwiceTraversalSolution().candy(new int[]{1, 3, 4, 7, 9, 5, 3, 100}));
    }
}
