package com.nxy006.project.algorithm.leetcode.p0881.boats_to_save_people;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.Arrays;

/**
 * 双指针解法（官方解法）
 * 时间复杂度：O(n·log_n)，空间复杂度：O(1)
 *
 * https://leetcode.com/problems/boats-to-save-people/solution/
 */
public class TwoPointOfficialSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TwoPointOfficialSolution(), 1, "[1,2]", 3);
        caseCheck(new TwoPointOfficialSolution(), 3, "[3,2,2,1]", 3);
        caseCheck(new TwoPointOfficialSolution(), 4, "[3,5,3,4]", 5);
    }

    private static void caseCheck(TwoPointOfficialSolution solution, int expected, String peopleArr, int limit) {
        CaseAssertUtils.assertEquals(expected,
                solution.numRescueBoats(StructConvertUtils.convertToIntArray(peopleArr), limit));
    }
}
