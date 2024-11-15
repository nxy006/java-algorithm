package com.nxy006.project.algorithm.leetcode.p0649.dota2_senate;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime  9 ms    , beats 90.74 % of java submissions.
 * Memory   44.8 MB , beats 65.90 % of java submissions.
 * 12/02/2021 19:00
 */
public class QueueSolution extends SolutionTemplate {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int numR = 0, numD = 0, banR = 0, banD = 0;
        for(char c : senate.toCharArray()) {
            if (c == 'R') {
                numR++;
            } else {
                numD++;
            }
            queue.offer(c);
        }

        while(!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'R') {
                if (banR > 0) {
                    banR--;
                    numR--;
                } else if (numD == 0) {
                    return "Radiant";
                } else {
                    banD++;
                    queue.offer(c);
                }
            } else {
                if (banD > 0) {
                    banD--;
                    numD--;
                } else if (numR == 0) {
                    return "Dire";
                } else {
                    banR++;
                    queue.offer(c);
                }
            }
        }
        return "";
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        processCaseTest(new QueueSolution());
    }
}
