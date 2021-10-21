package com.nxy006.project.algorithm.leetcode.p0380.insert_delete_getrandom_o1;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * 常规解法（Set + List）
 * 本题实际是特殊功能的 Set，用 Set 支持基本概念，用 List 支持取随机数检查即可。
 * 时间复杂度：O(1)，空间复杂度：O(n)
 *
 * Runtime 36   ms , beats 51.58 % of java submissions.
 * Memory  84.4 MB , beats 92.04 % of java submissions.
 * 10/21/2021 23:30
 */
public class Solution {
    private static class RandomizedSet {
        private List<Integer> list;
        private Set<Integer> set;

        public RandomizedSet() {
            this.list = new ArrayList<>();
            this.set = new HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }

            set.add(val);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!set.contains(val)) {
                return false;
            }
            set.remove(val);
            return true;
        }

        public int getRandom() {
            Random random = new Random();
            int num = -1;
            do {
                int index = random.nextInt(list.size());
                num = list.get(index);
            } while(!set.contains(num));
            return num;
        }
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例（因底层方法不支持空数组识别，传参有所修改，原始用例见题目所述）
        caseCheck(
                "[null, true, false, true, 2, true, false, 2]",
                "[\"RandomizedSet\", \"insert\", \"remove\", \"insert\", \"getRandom\", \"remove\", \"insert\", \"getRandom\"]",
                "[[0], [1], [2], [2], [0], [1], [2], [0]]");
    }

    // TODO 待优化，目前 getRandom 方法的概率检查并不支持
    private static void caseCheck(String expectedStr, String commandsStr, String argsStr) {
        String[] commands = StructConvertUtils.convertToStringArray(commandsStr);
        int[][] args = StructConvertUtils.convertToIntMatrix(argsStr);
        String[] expected = StructConvertUtils.convertToStringArray(expectedStr);

        RandomizedSet randomizedSet = null;
        for(int i = 0; i < commands.length && i < args.length; i++) {
            switch (commands[i]) {
                case "RandomizedSet":
                    randomizedSet = new RandomizedSet();
                    break;
                case "insert":
                    CaseAssertUtils.assertEquals(Boolean.parseBoolean(expected[i]), randomizedSet.insert(args[i][0]));
                    break;
                case "remove":
                    CaseAssertUtils.assertEquals(Boolean.parseBoolean(expected[i]), randomizedSet.remove(args[i][0]));
                    break;
                case "getRandom":
                    CaseAssertUtils.assertEquals(Integer.parseInt(expected[i]), randomizedSet.getRandom());
                    break;
            }
        }
    }
}
