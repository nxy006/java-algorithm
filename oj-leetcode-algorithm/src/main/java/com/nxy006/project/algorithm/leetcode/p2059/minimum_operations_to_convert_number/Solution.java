package com.nxy006.project.algorithm.leetcode.p2059.minimum_operations_to_convert_number;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import javafx.util.Pair;

import java.util.*;

public class Solution {
    private static final int MAX_OPER_COUNT = 1002;

    public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) {
            return 0;
        }

        Set<Integer> set = preCheck(nums, goal);
        if (!rangeValidate(start) || set.isEmpty()) {
            return -1;
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start, 0));

        int[] minCounts = new int[1001];
        Arrays.fill(minCounts, MAX_OPER_COUNT);

        int res = MAX_OPER_COUNT;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int key = pair.getKey(), count = pair.getValue();

            // 已有更快步骤到达当前值，或该值不在范围内
            if (!rangeValidate(key) || minCounts[key] < count || res < count) {
                continue;
            }
            minCounts[key] = Integer.min(minCounts[key], count);

            if (key == goal) {
                res = Integer.min(res, count);
            }
            if (set.contains(key)) {
                res = Integer.min(res, count + 1);
            }

            for(int num : nums) {
                if (rangeValidate(key + num) && count+1 < minCounts[key + num]) {
                    minCounts[key + num] = count+1;
                    queue.offer(new Pair<>(key + num, count + 1));
                }
                if (rangeValidate(key - num) && count+1 < minCounts[key - num]) {
                    minCounts[key - num] = count+1;
                    queue.offer(new Pair<>(key - num, count + 1));
                }
                if (rangeValidate(key ^ num) && count+1 < minCounts[key ^ num]) {
                    minCounts[key ^ num] = count+1;
                    queue.offer(new Pair<>(key ^ num, count + 1));
                }
            }
        }
        return res == MAX_OPER_COUNT ? -1 : res;
    }

    private Set<Integer> preCheck(int[] nums, int goal) {
        Set<Integer> set = new HashSet<>();
        if (rangeValidate(goal)) {
            set.add(goal);
        }

        for(int num : nums) {
            if (rangeValidate(goal-num)) {
                set.add(goal-num);
            }
            if (rangeValidate(goal+num)) {
                set.add(goal+num);
            }
            if (rangeValidate((goal^num))) {
                set.add((goal^num));
            }
        }
        return set;
    }

    private boolean rangeValidate(int n) {
        return 0 <= n && n <= 1000;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        CaseAssertUtils.assertEquals(2, new Solution().minimumOperations(new int[]{1, 3}, 6, 4));
        CaseAssertUtils.assertEquals(2, new Solution().minimumOperations(new int[]{2, 4, 12}, 2, 12));
        CaseAssertUtils.assertEquals(2, new Solution().minimumOperations(new int[]{3, 5, 7}, 0, -4));
        CaseAssertUtils.assertEquals(-1, new Solution().minimumOperations(new int[]{2, 8, 18}, 0, 1));
        CaseAssertUtils.assertEquals(3, new Solution().minimumOperations(new int[]{1}, 0, 3));
        // 自定义用例
        CaseAssertUtils.assertEquals(2, new Solution().minimumOperations(new int[]{1}, 1, 3));
        CaseAssertUtils.assertEquals(1, new Solution().minimumOperations(new int[]{1}, 2, 3));
    }
}
