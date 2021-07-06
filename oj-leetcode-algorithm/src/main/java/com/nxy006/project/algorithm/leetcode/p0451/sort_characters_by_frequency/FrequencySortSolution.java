package com.nxy006.project.algorithm.leetcode.p0451.sort_characters_by_frequency;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import javafx.util.Pair;

import java.util.*;

/**
 * 按出现频率排序解法
 * 时间复杂度：O(n + k·log_k)，n 为字符串长度，k 为字符串中不同字符的数量（本题只包含大写字母、小写字母和数字，因此 k=26+26+10=62）
 *     1. 遍历字符串统计每个字符出现的频率需要 O(n) 的时间
 *     2. 将字符按照出现频率排序需要 O(k·log_k) 的时间
 *     3. 生成排序后的字符串，需要遍历 k 个不同字符，需要 O(k) 的时间，拼接字符串需要 O(n) 的时间
 *     因此，总时间复杂度 O(n + k·log_k + k + n) = O(n + k·log_k)。
 *
 * 空间复杂度：O(n+k)，即字符串长度 n （List 大小）加不同字符的数量 k（Map 大小）
 *
 * Runtime  15 ms   , beats 47.99 % of java submissions.
 * Memory   39.6 MB , beats 81.66 % of java submissions.
 * 07/05/2021 22:10
 */
public class FrequencySortSolution {
    public String frequencySort(String s) {
        Map<Character, Integer> charCntMap = new HashMap<>(26);
        for(char c : s.toCharArray()) {
            charCntMap.put(c, charCntMap.getOrDefault(c, 0) + 1);
        }

        List<Pair<Character, Integer>> list = new ArrayList<>();
        for(Map.Entry entry : charCntMap.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        for(Pair<Character, Integer> pair : list) {
            for(int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        CaseAssertUtils.assertContains(new String[]{"eetr", "eert"}, new FrequencySortSolution().frequencySort("tree"));
        CaseAssertUtils.assertContains(new String[]{"cccaaa", "aaaccc"}, new FrequencySortSolution().frequencySort("cccaaa"));
        CaseAssertUtils.assertContains(new String[]{"bbAa", "bbaA"}, new FrequencySortSolution().frequencySort("Aabb"));
    }
}
