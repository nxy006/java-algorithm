package com.nxy006.project.algorithm.leetcode.p0050.powx_n;

/**
 * 模拟
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  6 ms    , beats  5.73 % of java submissions.
 * Memory   42.09 MB, beats 59.87 % of java submissions.
 * 12/11/2024 15:14
 */
public class Solution extends SolutionTemplate {
    public double myPow(double x, int n) {
        // 注意这里要直接计算 1/x 的幂，而非计算 x^n 后再用 1 除
        // 原因是当 n 非常大时，后续计算 x^n 会非常耗时，而用 1/x 就能在结果为 0 时尽快退出循环
        if (n < 0) {
            x = 1.0 / x;
        }

        // 特殊值直接处理
        if (x == 1.0 || x == 0.0) {
            return x;
        } else if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }

        // 注意 n 的范围是 int 范围
        // 如果在 n 为 MIN_VALUE 时调用 Math.abs 会返回零，导致运算错误
        double result = 1;
        if (n == Integer.MIN_VALUE) {
            result = x;
            n = Integer.MAX_VALUE;
        } else {
            n = Math.abs(n);
        }

        while(n-- > 0) {
            result *= x;

            // 同上说明，用于在 n 较大时尽早退出
            if (result == 0.0) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
