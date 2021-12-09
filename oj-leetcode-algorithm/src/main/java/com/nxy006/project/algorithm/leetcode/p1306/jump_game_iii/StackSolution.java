package com.nxy006.project.algorithm.leetcode.p1306.jump_game_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Stack;

/**
 * 栈解法
 *
 * Runtime 7 ms    , beats 29.98 % of java submissions.
 * Memory  46.5 MB , beats 94.88 % of java submissions.
 * 12/10/2021 00:24
 */
public class StackSolution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.empty()) {
            int i = stack.pop();
            if (arr[i] == 0) {
                return true;
            }
            if (arr[i] == -1) {
                continue;
            }

            if (checkIndex(i - arr[i], arr.length) && arr[i - arr[i]] != -1) {
                stack.push(i - arr[i]);
            }
            if (checkIndex(i + arr[i], arr.length) && arr[i + arr[i]] != -1) {
                stack.push(i + arr[i]);
            }
            arr[i] = -1;
        }
        return false;
    }

    private boolean checkIndex(int i, int len) {
        return i >= 0 && i < len;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new StackSolution(), true, "[4,2,3,0,3,1,2]", 5);
        caseCheck(new StackSolution(), true, "[4,2,3,0,3,1,2]", 0);
        caseCheck(new StackSolution(), false, "[3,0,2,1,2]", 2);
    }

    private static void caseCheck(StackSolution solution, boolean expected, String arrStr, int start) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.canReach(StructConvertUtils.convertToIntArray(arrStr), start));
    }
}
