package com.nxy006.project.algorithm.leetcode.p0001.two_sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  3 ms    , beats 58.77 % of java submissions.
 * Memory   40.1 MB , beats 22.34 % of java submissions.
 * 07/06/2021 11:29
 */
public class MapSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEqualsIgnoreOrder(new int[]{0, 1}, new MapSolution().twoSum(new int[]{2, 7, 11, 15}, 9));
        CaseAssertUtils.assertEqualsIgnoreOrder(new int[]{1, 2}, new MapSolution().twoSum(new int[]{3, 2, 4}, 6));
        CaseAssertUtils.assertEqualsIgnoreOrder(new int[]{0, 1}, new MapSolution().twoSum(new int[]{3, 3}, 6));
    }
}
