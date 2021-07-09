package com.nxy006.project.algorithm.leetcode.p0020.valid_parentheses;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Stack;

/**
 * TODO 待提交测试
 */
public class StackSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (stack.empty() || !isMatch(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    private boolean isMatch(char a, char b) {
        return a == '(' && b == ')' || a == '{' && b == '}' ||a == '[' && b == ']';
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(true, new StackSolution().isValid("()"));
        CaseAssertUtils.assertEquals(true, new StackSolution().isValid("()[]{}"));
        CaseAssertUtils.assertEquals(false, new StackSolution().isValid("(]"));
        CaseAssertUtils.assertEquals(false, new StackSolution().isValid("([)]"));
        CaseAssertUtils.assertEquals(true, new StackSolution().isValid("{[]}"));
    }
}
