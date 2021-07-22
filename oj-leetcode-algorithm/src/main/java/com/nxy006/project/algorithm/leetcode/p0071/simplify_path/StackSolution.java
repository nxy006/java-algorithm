package com.nxy006.project.algorithm.leetcode.p0071.simplify_path;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Stack;

/**
 * 栈解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  3 ms    , beats 96.47 % of java submissions.
 * Memory   39.2 MB , beats 54.08 % of java submissions.
 * 07/22/2021 23:47
 */
public class StackSolution {
    public String simplifyPath(String path) {
        int start = 0;
        Stack<String> stack = new Stack<>();
        path = "/" + path + "/";
        for(int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                String currPath = path.substring(start, i);
                switch (currPath) {
                    case "/":
                    case "/.":
                        break;
                    case "/..":
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        break;
                    default:
                        stack.push(currPath);
                }
                start = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals("/home", new StackSolution().simplifyPath("/home/"));
        CaseAssertUtils.assertEquals("/", new StackSolution().simplifyPath("/../"));
        CaseAssertUtils.assertEquals("/home/foo", new StackSolution().simplifyPath("/home//foo/"));
        CaseAssertUtils.assertEquals("/c", new StackSolution().simplifyPath("/a/./b/../../c/"));
        // 自定义用例
        CaseAssertUtils.assertEquals("/b", new StackSolution().simplifyPath("/a/../../../b/"));
        CaseAssertUtils.assertEquals("/", new StackSolution().simplifyPath("/././"));
        CaseAssertUtils.assertEquals("/a", new StackSolution().simplifyPath("/a/"));
        CaseAssertUtils.assertEquals("/b/cdc", new StackSolution().simplifyPath("/b/cdc/"));
    }
}
