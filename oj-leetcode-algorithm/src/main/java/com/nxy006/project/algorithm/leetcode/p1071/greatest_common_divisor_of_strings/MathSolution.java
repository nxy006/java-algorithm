
package com.nxy006.project.algorithm.leetcode.p1071.greatest_common_divisor_of_strings;

/**
 * 数学解法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * <p/>
 * 这个解法很简单，但不知道怎么证明正确性。
 * str1+str2 与 str2+str1 相等时，则说明两个字符串是满足公共子串重复的场景，再取长度最大公约数即可
 *
 * Runtime  0 ms    , beats 100.00 % of java submissions.
 * Memory   41.88 MB, beats  88.42 % of java submissions.
 * 12/11/2024 19:25
 */
public class MathSolution extends SolutionTemplate {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals((str2+str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        processCaseTest(new MathSolution());
    }
}
