package com.nxy006.project.algorithm.leetcode.p1337.the_k_weakest_rows_in_a_matrix;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map 解法
 * 时间复杂度：O(n)，空间复杂度：O(n)
 *
 * Runtime 3 ms    , beats 60.90 % of java submissions.
 * Memory  48.1 MB , beats 73.87 % of java submissions.
 * 03/27/2022 22:37
 */
public class MapSolution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int cnt = countSoldiers(row);

            List<Integer> list = map.getOrDefault(cnt, new ArrayList<>());
            list.add(i);
            map.put(cnt, list);

            if (cnt == 0 && list.size() >= k) {                 // 优化点：如果最小的值已经有 k 个，不再需要遍历
                break;
            }
        }

        int[] ans = new int[k];
        int i = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(int index : entry.getValue()) {
                ans[i++] = index;
                if (i >= k) {
                    break;
                }
            }
            if (i >= k) {
                break;
            }
        }
        return ans;
    }

    private int countSoldiers(int[] row) {
        for(int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                return i;
            }
        }
        return row.length;
    }

    // ---------------------------------------------------------- OTHER CODE ---------------------------------------------------------- //

    // 二分算法版本：可能因用例原因，实测速度并没有明显变化
    private int countSoldiersOptimized(int[] row) {
        if (row[row.length - 1] == 1) {
            return row.length;
        }

        int l = 0, r = row.length - 1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if (row[mid] == 1) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        // 官方用例
        caseCheck(new MapSolution(),
                "[2,0,3]",
                "[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]", 3);
        caseCheck(new MapSolution(),
                "[0,2]",
                "[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]]", 2);
        // 提交失败用例
        caseCheck(new MapSolution(),
                "[4]",
                "[[1,1],[1,0],[1,0],[1,1],[0,0],[1,1]]", 1);
    }

    private static void caseCheck(MapSolution solution, String expectedArr, String matStr, int k) {
        CaseAssertUtils.assertEquals(
                StructConvertUtils.convertToIntArray(expectedArr),
                solution.kWeakestRows(StructConvertUtils.convertToIntMatrix(matStr), k));
    }
}
