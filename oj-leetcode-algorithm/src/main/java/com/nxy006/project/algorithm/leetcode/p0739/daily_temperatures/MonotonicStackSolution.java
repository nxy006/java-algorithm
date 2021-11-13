package com.nxy006.project.algorithm.leetcode.p0739.daily_temperatures;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime 93 ms    , beats 14.21 % of java submissions.
 * Memory  117.5 MB , beats 28.20 % of java submissions.
 * 11/14/2021 00:09
 */
public class MonotonicStackSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        for(int i = 0; i < temperatures.length; i++) {
            Pair<Integer, Integer> peek = stack.empty() ? null : stack.peek();
            while (peek != null && peek.getValue() < temperatures[i]) {
                stack.pop();
                ans[peek.getKey()] = i - peek.getKey();
                peek = stack.empty() ? null : stack.peek();
            }

            stack.push(new Pair<>(i, temperatures[i]));
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new MonotonicStackSolution(), "[1,1,4,2,1,1,0,0]", "[73,74,75,71,69,72,76,73]");
        caseCheck(new MonotonicStackSolution(), "[1,1,1,0]", "[30,40,50,60]");
        caseCheck(new MonotonicStackSolution(), "[1,1,0]", "[30,60,90]");
        // 自定义用例
        caseCheck(new MonotonicStackSolution(), "[0,0,0]", "[30,30,30]");
        caseCheck(new MonotonicStackSolution(), "[1,1,0]", "[31,32,33]");
        caseCheck(new MonotonicStackSolution(), "[0,0,0]", "[33,32,31]");
        caseCheck(new MonotonicStackSolution(),
                "[1,1,0,1,4,1,2,1,0,0,0,0,1,0,4,3,2,1,0,1,0,1,0]",
                "[35,38,39,31,32,30,31,30,38,35,34,32,30,31,30,30,30,30,31,30,31,30,31]");
    }

    private static void caseCheck(MonotonicStackSolution solution, String expectedArr, String arrStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntArray(expectedArr),
                solution.dailyTemperatures(StructConvertUtils.convertToIntArray(arrStr))
        );
    }
}
