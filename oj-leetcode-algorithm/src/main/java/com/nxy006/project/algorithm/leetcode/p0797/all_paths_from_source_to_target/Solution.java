package com.nxy006.project.algorithm.leetcode.p0797.all_paths_from_source_to_target;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.*;

/**
 * 常规解法
 * 递归遍历（深度优先）所有路径即可
 *
 * Runtime 4 ms    , beats 48.56 % of java submissions.
 * Memory  41.3 MB , beats 43.61 % of java submissions.
 * 11/29/2021 00:16
 */
public class Solution {
    // map 记录的是从 key 节点开始到目标节点的所有路径
    Map<Integer, List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lastPath = new ArrayList<>();
        lastPath.add(new ArrayList<>(Arrays.asList(graph.length - 1)));
        map.put(graph.length - 1, lastPath);

        return allPathsSourceTarget(graph, graph.length - 1, 0);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph, int target, int current) {
        if (map.containsKey(current)) {
            return map.get(current);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int next : graph[current]) {
            List<List<Integer>> nextPaths = allPathsSourceTarget(graph, target, next);
            if (nextPaths == null) {
                continue;
            }

            for(List<Integer> nextPath : nextPaths) {
                List<Integer> path = new ArrayList<>();
                path.add(current);
                path.addAll(nextPath);
                res.add(path);
            }
        }
        map.put(current, res);
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        // TODO 因转换工具暂无法识别嵌套空数组（ [[1],[]]），此处将所有 graphStr 最后的空数组 [] 均修改为了 [0]，仅供本解法使用，其他解法可能报错
        caseCheck(new Solution(), "[[0,1,3],[0,2,3]]", "[[1,2],[3],[3],[0]]");
        caseCheck(new Solution(), "[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]", "[[4,3,1],[3,2,4],[3],[4],[0]]");
        caseCheck(new Solution(), "[[0,1]]", "[[1],[0]]");
        caseCheck(new Solution(), "[[0,1,2,3],[0,2,3],[0,3]]", "[[1,2,3],[2],[3],[0]]");
        caseCheck(new Solution(), "[[0,1,2,3],[0,3]]", "[[1,3],[2],[3],[0]]");
    }

    private static void caseCheck(Solution solution, String expectedStr, String graphStr) {
        CaseAssertUtils.assertEqualsIgnoreOrder(
                StructConvertUtils.convertToIntegerNestedList(expectedStr),
                solution.allPathsSourceTarget(StructConvertUtils.convertToIntMatrix(graphStr))
        );
    }
}
