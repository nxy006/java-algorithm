package com.nxy006.project.algorithm.leetcode.p1047.remove_all_adjacent_duplicates_in_string;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Stack;

/**
 * 栈解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  49 ms   , beats 27.68 % of java submissions.
 * Memory   39.7 MB , beats 41.51 % of java submissions.
 * 06/28/2021 23:45
 */
public class StackSolution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals("ca", new StackSolution().removeDuplicates("abbaca"));
        CaseAssertUtils.assertEquals("ay", new StackSolution().removeDuplicates("azxxzy"));
    }
}
