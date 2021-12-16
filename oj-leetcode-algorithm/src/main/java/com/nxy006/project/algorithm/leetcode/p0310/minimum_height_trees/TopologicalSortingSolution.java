package com.nxy006.project.algorithm.leetcode.p0310.minimum_height_trees;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * 拓扑排序解法
 * 本题可以理解为求无向图中最中心的节点值，因此每次将最外层（只与一个节点连接）的节点全部删除，最后留下的节点即为答案
 * 时间复杂度：O(V)，空间复杂度：O(V)，V是节点的数量
 *
 * Runtime  215 ms  , beats   5.04 % of java submissions.
 * Memory   53.7 MB , beats  17.30 % of java submissions.
 * 12/17/2021 00:31
 */
public class TopologicalSortingSolution {
    // 映射所有两点之间的边
    Map<Integer, List<Integer>> edgeMap = new HashMap<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        List<Integer> list;
        for(int[] edge : edges) {
            list = edgeMap.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            edgeMap.put(edge[0], list);

            list = edgeMap.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            edgeMap.put(edge[1], list);
        }

        // 最中心的节点，必然为一个或两个
        while(edgeMap.size() > 2) {
            List<Integer> removeList = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry: edgeMap.entrySet()) {
                list = entry.getValue();
                // 找所有到度为1的节点，即最外层节点
                if (list.size() == 1) {
                    removeList.add(entry.getKey());
                }
            }

            // 将所有度为1的节点统一移除
            for(int remove : removeList) {
                list = edgeMap.get(remove);
                int otherRemove = list.get(0);

                edgeMap.remove(remove);
                list = edgeMap.get(otherRemove);
                list.remove(Integer.valueOf(remove));
            }
        }

        // 组装相应
        List<Integer> res  = new ArrayList<>();
        for(int key : edgeMap.keySet()) {
            res.add(key);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new TopologicalSortingSolution(), "[1]", 4, "[[1,0],[1,2],[1,3]]");
        caseCheck(new TopologicalSortingSolution(), "[3,4]", 6, "[[3,0],[3,1],[3,2],[3,4],[5,4]]");
        caseCheck(new TopologicalSortingSolution(), "[0]", 1, "[]");
        caseCheck(new TopologicalSortingSolution(), "[0,1]", 2, "[[0,1]]");
        // 提交失败用例
        caseCheck(new TopologicalSortingSolution(), "[3]", 6, "[[0,1],[0,2],[0,3],[3,4],[4,5]]");
    }

    private static void caseCheck(TopologicalSortingSolution solution, String expectedStr, int n, String edgesStr) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntegerList(expectedStr),
                solution.findMinHeightTrees(n, StructConvertUtils.convertToIntMatrix(edgesStr)));
    }
}
