package com.nxy006.project.algorithm.leetcode.p0933.number_of_recent_calls;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  22 ms   , beats 62.03 % of java submissions.
 * Memory   53.9 MB , beats 61.25 % of java submissions.
 * 15/11/2024 18:43
 */
public class Solution extends SolutionTemplate {
    Queue<Integer> queue;

    public Solution() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while(!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }

    CaseAssertUtils.SolutionProcessor<int[]> getProcessor(int[] params) {
        return () -> {
            SolutionTemplate solution = new Solution();
            int[] result = new int[params.length];
            for(int i = 0; i < params.length; i++) {
                result[i] = solution.ping(params[i]);
            }
            return result;
        };
    }


}
