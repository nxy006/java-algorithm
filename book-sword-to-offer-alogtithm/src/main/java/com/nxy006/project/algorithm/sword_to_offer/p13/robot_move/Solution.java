package com.nxy006.project.algorithm.sword_to_offer.p13.robot_move;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

/**
 * 《剑指Offer —— 名企面试官精讲典型编程题 第 2 版》
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 *       每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 *       大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 *       但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 官解：https://github.com/zhedahht/CodingInterviewChinese2/tree/master/13_RobotMove
 *
 * TODO 待提交测试
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        return movingCount(m, n, k, new boolean[m][n], 0, 0);
    }

    public int movingCount(int m, int n, int k, boolean[][] exist, int i, int j) {
        if (i >= m || j >= n || sumOfBit(i) + sumOfBit(j) > k || exist[i][j]) {
            return 0;
        }
        exist[i][j] = true;
        return movingCount(m, n, k, exist, i+1, j) + movingCount(m, n, k, exist, i, j+1) + 1;
    }

    private int sumOfBit(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        return sum + n;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertEquals(3, new Solution().movingCount(2, 3, 1));
        CaseAssertUtils.assertEquals(1, new Solution().movingCount(3, 1, 0));
    }
}
