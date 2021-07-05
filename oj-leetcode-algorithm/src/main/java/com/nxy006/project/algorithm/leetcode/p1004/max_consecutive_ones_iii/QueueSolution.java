package com.nxy006.project.algorithm.leetcode.p1004.max_consecutive_ones_iii;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列解法
 * 时间复杂度：O(n)，空间复杂度：O(k)
 *
 * Runtime  7 ms    , beats   9.54 % of java submissions.
 * Memory   43.8 MB , beats  16.40 % of java submissions.
 * 06/30/2021 00:20
 */
public class QueueSolution {
    // 解法的思路类似双指针，为每个结束位置寻找其最小的初始位置
    // 一旦占用到 k 个翻转，就取消第一个翻转，因而需要一个队列保留所有发生翻转的位置记录
    public int longestOnes(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();

        int start = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max = Integer.max(max, i-start+1);
            } else if (k > 0) {
                queue.offer(i);
                if (queue.size() > k) {
                    start = queue.poll() + 1;
                }
                max = Integer.max(max, i-start+1);
            } else {
                start = i+1;
            }
        }
        return max;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new QueueSolution(), "1,1,1,0,0,0,1,1,1,1,0", 2, 6);
        caseCheck(new QueueSolution(), "0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1", 3, 10);
    }

    private static void caseCheck(QueueSolution solution, String s, int k, int expected) {
        CaseAssertUtils.assertEquals(expected, solution.longestOnes(StructConvertUtils.convertToIntArray(s, ","), k));
    }
}
