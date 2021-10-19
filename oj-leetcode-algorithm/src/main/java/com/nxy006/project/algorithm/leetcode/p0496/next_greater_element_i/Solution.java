package com.nxy006.project.algorithm.leetcode.p0496.next_greater_element_i;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 常规解法
 * 遍历列表内所有数据，并存储第一个大于其的数字
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime 232 ms  , beats  5.02 % of java submissions.
 * Memory  56.6 MB , beats  6.29 % of java submissions.
 * 10/19/2021 23:51
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> greaterMap = new HashMap<>();
        for(int num : nums2) {
            for(int value : set) {
                if (value < num && !greaterMap.containsKey(value)) {
                    greaterMap.put(value, num);
                }
            }
            set.add(num);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = greaterMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new Solution(), "[-1,3,-1]", "[4,1,2]", "[1,3,4,2]");
        caseCheck(new Solution(), "[3,-1]", "[2,4]", "[1,2,3,4]");
        // 自定义用例
        caseCheck(new Solution(), "[2,3,4]", "[1,2,3]", "[1,2,3,4]");
        caseCheck(new Solution(), "[4,3,2]", "[3,2,1]", "[1,2,3,4]");
        caseCheck(new Solution(), "[-1,-1,-1]", "[1,2,3]", "[4,3,2,1]");
        // 提交失败用例
        caseCheck(new Solution(), "[7,7,7,7,7]", "[1,3,5,2,4]", "[6,5,4,3,2,1,7]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String nums1Str, String nums2Str) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntArray(expectedStr),
                solution.nextGreaterElement(
                        StructConvertUtils.convertToIntArray(nums1Str), StructConvertUtils.convertToIntArray(nums2Str)));
    }
}
