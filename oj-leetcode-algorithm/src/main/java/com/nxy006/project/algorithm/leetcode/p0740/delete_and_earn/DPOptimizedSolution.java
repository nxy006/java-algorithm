package com.nxy006.project.algorithm.leetcode.p0740.delete_and_earn;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划解法优化：
 *   1. 将原有分段求最优解修改为一次性计算
 *   2. maxPoints 方法利用输入 List 存储动态规划数据，不再额外使用数组
 * 时间复杂度：O(n)，空间复杂度：O(m)
 *
 * Runtime  4 ms    , beats  71.72 % of java submissions.
 * Memory   41.7 MB , beats  75.89 % of java submissions.
 * 03/05/2022 19:15
 */
public class DPOptimizedSolution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int current = nums[0], sum = 0;
        List<Integer> list = new ArrayList<>();     // 还可以进一步优化为使用原数组记录，继续节约空间小号
        for(int num :  nums) {
            if (num > current + 1) {
                list.add(sum);
                list.add(0);                        // 添加 0 隔开不连续数字，以做到一次性计算结果
                sum = 0;
            } else if (num != current) {
                list.add(sum);
                sum = 0;
            }

            sum += num;
            current = num;
        }
        list.add(sum);
        return maxPoints(list);
    }

    private int maxPoints(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 2) {
            return Integer.max(list.get(0), list.get(1));
        }

        list.set(2, list.get(0) + list.get(2));
        for(int i = 3; i < list.size(); i++) {
            list.set(i, list.get(i) + Integer.max(list.get(i-2), list.get(i-3)));
        }

        return Integer.max(list.get(list.size()-1), list.get(list.size()-2));
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new DPOptimizedSolution(), 6, "[3,4,2]");
        caseCheck(new DPOptimizedSolution(), 9, "[2,2,3,3,3,4]");
        // 自定义用例
        caseCheck(new DPOptimizedSolution(), 1, "[1]");
        caseCheck(new DPOptimizedSolution(), 7, "[1,1,1,1,1,1,1]");
        caseCheck(new DPOptimizedSolution(), 2011, "[1,5,9,150,1846]");
        caseCheck(new DPOptimizedSolution(), 4, "[1,2,3]");
        caseCheck(new DPOptimizedSolution(), 6, "[1,2,3,4]");
        // 提交失败用例
        caseCheck(new DPOptimizedSolution(), 338,
                "[10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9," +
                    "10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5]");
    }

    private static void caseCheck(DPOptimizedSolution solution, int expected, String s) {
        CaseAssertUtils.assertEquals(expected, solution.deleteAndEarn(StructConvertUtils.convertToIntArray(s)));
    }
}
