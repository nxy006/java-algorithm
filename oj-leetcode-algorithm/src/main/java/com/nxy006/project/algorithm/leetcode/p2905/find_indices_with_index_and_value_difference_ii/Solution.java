package com.nxy006.project.algorithm.leetcode.p2905.find_indices_with_index_and_value_difference_ii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.List;

public class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int min = nums[0], max = nums[0], minIndex = 0, maxIndex = 0;
        for(int i = indexDifference; i < nums.length; i++) {
            int j = i - indexDifference;
            if (nums[j] > max) {
                max = nums[j];
                maxIndex = j;
            }
            if (nums[j] < min) {
                min = nums[j];
                minIndex = j;
            }

            if (Math.abs(nums[i]-min) >= valueDifference) {
                return new int[]{minIndex, i};
            } else if (Math.abs(max-nums[i]) >= valueDifference) {
                return new int[]{maxIndex, i};
            }
        }

        return new int[]{-1, -1};
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[[0,3],[3,0]]", "[5,1,4,1]", 2, 4);
        caseCheck(new Solution(), "[[0,0]]", "[2,1]", 0, 0);
        caseCheck(new Solution(), "[[-1,-1]]", "[1,2,3]", 2, 4);
    }

    private static void caseCheck(Solution solution, String expectedarrays, String arrayStr, int indexDifference, int valueDifference) {
        CaseAssertUtils.assertContains(
                StructConvertUtils.convertToIntMatrix(expectedarrays),
                solution.findIndices(StructConvertUtils.convertToIntArray(arrayStr), indexDifference, valueDifference));
    }
}
