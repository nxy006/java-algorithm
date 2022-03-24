package com.nxy006.project.algorithm.leetcode.p0881.boats_to_save_people;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 双指针解法
 * 时间复杂度：O(n·log_n)，空间复杂度：O(1)
 *
 * Runtime  14 ms   , beats 97.12 % of java submissions.
 * Memory   50.3 MB , beats 92.76 % of java submissions.
 * 03/24/2022 15:55
 */
public class TwoPointSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, cnt = 0;

        // 可参考官方解法，更为简洁：TwoPointOfficialSolution
        while(i < j) {
            cnt++;
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        return cnt + (i == j ? 1 : 0);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointSolution(), 1, "[1,2]", 3);
        caseCheck(new TwoPointSolution(), 3, "[3,2,2,1]", 3);
        caseCheck(new TwoPointSolution(), 4, "[3,5,3,4]", 5);
    }

    private static void caseCheck(TwoPointSolution solution, int expected, String peopleArr, int limit) {
        CaseAssertUtils.assertEquals(expected,
                solution.numRescueBoats(StructConvertUtils.convertToIntArray(peopleArr), limit));
    }
}
