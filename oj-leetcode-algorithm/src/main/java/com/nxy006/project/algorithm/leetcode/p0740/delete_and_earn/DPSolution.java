package com.nxy006.project.algorithm.leetcode.p0740.delete_and_earn;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划解法
 * 对不能取相邻元素的数组 arr[]，最后取到的位置为 i 时能取到的最大和为：
 * （已取 i 时不能再取 i-1，而取 i-4 没有必要，i-2 已包括此情形）
 *     result[0] = arr[0]
 *     result[1] = arr[1]
 *     result[2] = max(arr[0], arr[1])
 *     result[i] = arr[i] + max(result[i-2], result[i-3])
 * 时间复杂度：O(n)，空间复杂度：O(m)
 *
 * Runtime  5 ms    , beats  58.38 % of java submissions.
 * Memory   43.9 MB , beats  44.81 % of java submissions.
 * 03/05/2022 18:02
 */
public class DPSolution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int current = nums[0], sum = 0, points = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != current) {
                list.add(sum);
                sum = 0;

                if (nums[i] > current + 1) {
                    points += maxPoints(list);
                    list = new ArrayList<>();
                }
            }

            sum += nums[i];
            current = nums[i];
        }
        list.add(sum);
        points += maxPoints(list);

        return points;
    }

    private int maxPoints(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 2) {
            return Integer.max(list.get(0), list.get(1));
        }

        int[] arr = new int[list.size()];
        arr[0] = list.get(0);
        arr[1] = list.get(1);
        arr[2] = list.get(0) + list.get(2);
        for(int i = 3; i < list.size(); i++) {
            arr[i] = list.get(i) + Integer.max(arr[i-2], arr[i-3]);
        }

        return Integer.max(arr[list.size()-1], arr[list.size()-2]);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPSolution(), 6, "[3,4,2]");
        caseCheck(new DPSolution(), 9, "[2,2,3,3,3,4]");
        // 自定义用例
        caseCheck(new DPSolution(), 1, "[1]");
        caseCheck(new DPSolution(), 7, "[1,1,1,1,1,1,1]");
        caseCheck(new DPSolution(), 2011, "[1,5,9,150,1846]");
        caseCheck(new DPSolution(), 4, "[1,2,3]");
        caseCheck(new DPSolution(), 6, "[1,2,3,4]");
        // 提交失败用例
        caseCheck(new DPSolution(), 338,
                "[10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9," +
                    "10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5]");
    }

    private static void caseCheck(DPSolution solution, int expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.deleteAndEarn(StructConvertUtils.convertToIntArray(s)));
    }
}
