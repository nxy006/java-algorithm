package com.nxy006.project.algorithm.leetcode.p0752.open_the_lock;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;
import javafx.util.Pair;

import java.util.*;

/**
 *  宽度优先搜索
 *  时间复杂度：O(b^d*d^2 + md)，空间复杂度：O(b^d*d + md)
 *  其中 b 是数字的进制，d 是转盘数字的位数，m 是数组 deadends 的长度，本题中 b=10，d=4
 *
 *  Runtime  67 ms   , beats 86.02 % of java submissions.
 *  Memory   44.2 MB , beats 77.50 % of java submissions.
 *  08/07/2021 23:06
 */
public class BFSSolution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)){
            return 0;
        }

        // Init existed Set
        Set<String> exist = new HashSet<>();
        for(String deadend : deadends) {
            if (deadend.equals("0000")) {
                return -1;
            }
            exist.add(deadend);
        }

        // Init Queue
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        exist.add("0000");

        // BFS
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            for(String nextStatus : nextStatuses(pair.getKey())) {
                if (exist.contains(nextStatus)) {
                    continue;
                }
                if (nextStatus.equals(target)) {
                    return pair.getValue() + 1;
                }

                exist.add(nextStatus);
                queue.offer(new Pair<>(nextStatus, pair.getValue() + 1));
            }
        }
        return -1;
    }

    private List<String> nextStatuses(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < 4; i++) {
            char origin = chars[i];

            chars[i] = origin+1 > '9' ? '0' : (char)(origin+1);
            list.add(new String(chars));
            chars[i] = origin-1 < '0' ? '9' : (char)(origin-1);
            list.add(new String(chars));

            chars[i] = origin;
        }
        return list;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new BFSSolution(), 6, "[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]", "0202");
        caseCheck(new BFSSolution(), 1, "[\"8888\"]", "0009");
        caseCheck(new BFSSolution(), -1, "[\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"]", "8888");
        caseCheck(new BFSSolution(), -1, "[\"0000\"]", "8888");
        // 自定义用例
        caseCheck(new BFSSolution(), 0, "[\"8888\"]", "0000");
    }

    private static void caseCheck(BFSSolution solution, int expected, String arrStr, String target) {
        CaseAssertUtils.assertEquals(
                expected,
                solution.openLock(StructConvertUtils.convertToStringArray(arrStr), target));
    }
}
