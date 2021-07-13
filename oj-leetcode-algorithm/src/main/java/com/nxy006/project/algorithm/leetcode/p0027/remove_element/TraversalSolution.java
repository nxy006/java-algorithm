package com.nxy006.project.algorithm.leetcode.p0027.remove_element;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

/**
 * 遍历解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   37.7 MB , beats  36.68 % of java submissions.
 * 07/13/2021 22:39
 */
public class TraversalSolution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TraversalSolution(), "[2,2]","[3,2,2,3]", 3);
        caseCheck(new TraversalSolution(), "[0,1,4,0,3]","[0,1,2,2,3,0,4,2]", 2);
        // 自定义用例
        caseCheck(new TraversalSolution(), "[]","[2,2,2,2]", 2);
        caseCheck(new TraversalSolution(), "[0]","[0]", 7);
        caseCheck(new TraversalSolution(), "[]","[]", 5);
    }

    private static void caseCheck(TraversalSolution solution, String expectedNumsStr, String numsStr, int val) {
        int[] nums = StructConvertUtils.convertToIntArray(numsStr), expectedNums = StructConvertUtils.convertToIntArray(expectedNumsStr);
        CaseAssertUtils.assertEquals(expectedNums.length, solution.removeElement(nums, val));
        CaseAssertUtils.assertEqualsIgnoreOrderWithLength(expectedNums, nums, expectedNums.length);
    }
}
