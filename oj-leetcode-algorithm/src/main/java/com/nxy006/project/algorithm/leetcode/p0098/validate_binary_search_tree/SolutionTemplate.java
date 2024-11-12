package com.nxy006.project.algorithm.leetcode.p0098.validate_binary_search_tree;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

public abstract class SolutionTemplate {
    abstract boolean isValidBST(TreeNode root);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, true, "[2,1,3]");
        caseCheck(solution, false, "[5,1,4,null,null,3,6]");
        // 自定义用例
        caseCheck(solution, true, "[5,4,null,3,null,2,null,1]");
        caseCheck(solution, false, "[5,4,null,3,null,2,null,6]");
        caseCheck(solution, false, "[2,2,2]");
        caseCheck(solution, false, "[-2147483648,-2147483648,null]");
    }

    private static void caseCheck(SolutionTemplate solution, boolean expected, String treeStr) {
        CaseAssertUtils.assertEquals(expected, solution.isValidBST(StructConvertUtils.convertToTreeNode(treeStr)));
    }
}
