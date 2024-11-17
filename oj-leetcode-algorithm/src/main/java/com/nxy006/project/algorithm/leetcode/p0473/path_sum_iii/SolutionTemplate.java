package com.nxy006.project.algorithm.leetcode.p0473.path_sum_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

public abstract class SolutionTemplate {
    abstract int pathSum(TreeNode root, int targetSum);

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void processCaseTest(SolutionTemplate solution) {
        // 官方用例
        caseCheck(solution, 3, "[10,5,-3,3,2,null,11,3,-2,null,1]", 8);
        caseCheck(solution, 3, "[5,4,8,11,null,13,4,7,2,null,null,5,1]", 22);
        // 失败用例
        caseCheck(solution, 0, "[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]", 0);
    }

    private static void caseCheck(SolutionTemplate solution, int expected, String treeStr, int targetSum) {
        CaseAssertUtils.assertEquals(expected,
                () -> solution.pathSum(StructConvertUtils.convertToTreeNode(treeStr), targetSum));
    }
}
