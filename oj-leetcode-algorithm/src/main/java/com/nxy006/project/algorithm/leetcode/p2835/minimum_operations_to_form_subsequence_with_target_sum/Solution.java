package com.nxy006.project.algorithm.leetcode.p2835.minimum_operations_to_form_subsequence_with_target_sum;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.List;

/**
 * 模拟算法
 * 时间复杂度：O(n)，空间复杂度：O(1)
 *
 * Runtime  2 ms     , beats  100.00 % of java submissions.
 * Memory   43.30 MB , beats  33.33  % of java submissions.
 * 27/08/2023 10:33
 */
public class Solution {
    private int[] POWERS = new int[32];
    public int minOperations(List<Integer> nums, int target) {
        initPowers();

        int[] targetBits = initBitArray(target), currentNums = new int[32];
        for(int num : nums) {
            for(int i = 0; i <= 30; i++) {
                if (POWERS[i] == num) {
                    currentNums[i]++;
                    break;
                }
            }
        }

        int opr = 0;
        for(int i = 0; i <= 30; i++) {
            if (targetBits[i] == 0 || currentNums[i] > 0) {
                continue;
            } else if (tryFromMinNumber(currentNums, targetBits, i)) {
                continue;
            } else {
                if (currentNums[i] > 0) {
                    continue;
                }

                int nextIndex = nextNumIndex(currentNums, i);
                if (nextIndex == -1) {
                    return -1;
                } else {
                    opr += fillNumberWithIndex(currentNums, i, nextIndex);
                }
            }
        }

        return opr;
    }

    private void initPowers() {
        int power = 1;
        for(int i = 0; i <= 30; i++) {
            POWERS[i] = power;
            power *= 2;
        }
    }

    private int[] initBitArray(int target) {
        int[] arr = new int[32];
        int i = 0;
        while(target != 0) {
            if ((target & 1) == 1) {
                arr[i] = 1;
            }
            target = target >> 1;
            i++;
        }
        return arr;
    }

    private boolean tryFromMinNumber(int[] currentNums, int[] targetBits, int currentIndex) {
        int temp = 0;
        for(int i = 0; i < currentIndex; i++) {
            int sum = currentNums[i] - targetBits[i] + temp;
            temp = sum / 2;
            currentNums[i] = sum % 2;
        }
        currentNums[currentIndex] += temp;
        return temp > 0;
    }

    private int nextNumIndex(int[] currentNums, int currentIndex) {
        for(int j = currentIndex+1; j <= 30; j++) {
            if (currentNums[j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private int fillNumberWithIndex(int[] currentNums, int currentIndex, int nextIndex) {
        currentNums[currentIndex] += 2;
        currentNums[nextIndex] -= 1;
        for(int i = currentIndex+1; i < nextIndex; i++) {
            currentNums[i]++;
        }
        return nextIndex - currentIndex;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例

        // 错误用例
        caseCheck(new Solution(), 0,
                "[262144,512,16384,8,2048,8192,536870912,4096,524288,16777216,4194304,2,65536,64,256,8388608,1048576,67108864," +
                        "1073741824,1,1024,134217728,33554432,128,32768,16,4,131072,268435456,32,2097152]", 2147483647);
        caseCheck(new Solution(), -1,
                "[1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576,1048576," +
                        "1048576,1048576,1048576,1048576,1048576,1048576]", 1073741824);

    }

    private static void caseCheck(Solution solution, int expected, String numsStr, int target) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.minOperations(StructConvertUtils.convertToIntegerList(numsStr), target));
    }
}
