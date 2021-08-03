package com.nxy006.project.algorithm.leetcode.p0015._3sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * Map 解法
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 *
 * Runtime  619 ms  , beats 13.48 % of java submissions.
 * Memory   45.9 MB , beats 16.43 % of java submissions.
 * 08/03/2021 22:26
 */
public class MapSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 保证每次的三元组均有序，以帮助过滤重复解
        Arrays.sort(nums);

        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();
        Set<String> existAnsSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int k;
                if (j < (k = numMap.getOrDefault(-nums[i]-nums[j], -1))) {
                    String ans = nums[i] + "," + nums[j] + "," + nums[k];
                    if (!existAnsSet.contains(ans)) {
                        existAnsSet.add(ans);
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new MapSolution(), "[[-1,-1,2],[-1,0,1]]", "[-1,0,1,2,-1,-4]");
        caseCheck(new MapSolution(), "[]", "[]");
        caseCheck(new MapSolution(), "[]", "[0]");
        // 自定义用例
        caseCheck(new MapSolution(), "[[-4,2,2],[-1,-1,2],[-1,0,1]]", "[-1,0,1,2,-1,-4,1,1,-1,-1,-1,0,1,1,2]");
        caseCheck(new MapSolution(), "[]", "[1,1,1,1,1,1,1,1,1]");
        caseCheck(new MapSolution(), "[[-1,0,1]]", "[-1,-1,1,0,1,1,-1,1,1,1]");
    }

    private static void caseCheck(MapSolution solution, String expected, String numsStr) {
        // TODO 实际内层 List 也不要求排序
        CaseAssertUtils.assertEqualsIgnoreOrder(
                StructConvertUtils.convertToIntegerNestedList(expected),
                solution.threeSum(StructConvertUtils.convertToIntArray(numsStr)));
    }
}
