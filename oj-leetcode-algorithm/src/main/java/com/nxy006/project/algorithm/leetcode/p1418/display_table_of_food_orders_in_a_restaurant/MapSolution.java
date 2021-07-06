package com.nxy006.project.algorithm.leetcode.p1418.display_table_of_food_orders_in_a_restaurant;

import java.util.*;

/**
 * Map 解法
 *
 * Runtime  54 ms   , beats  28.96 % of java submissions.
 * Memory   65.2 MB , beats  38.25 % of java submissions.
 * 07/07/2021 00:57
 */
public class MapSolution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<Integer, Integer>> map = new TreeMap<>();
        Set<Integer> tables = new TreeSet<>();
        for(List<String> order : orders) {
            Map<Integer, Integer> orderMap = map.getOrDefault(order.get(2), new HashMap<Integer, Integer>());
            orderMap.put(Integer.valueOf(order.get(1)), orderMap.getOrDefault(Integer.valueOf(order.get(1)), 0) + 1);
            tables.add(Integer.valueOf(order.get(1)));
            map.put(order.get(2), orderMap);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("Table");
        for(Map.Entry<String, Map<Integer, Integer>> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        res.add(list);
        for(int table : tables) {
            list = new ArrayList<>();
            list.add(table + "");
            for(Map.Entry<String, Map<Integer, Integer>> entry : map.entrySet()) {
                Map<Integer, Integer> orderMap = entry.getValue();
                list.add(orderMap.getOrDefault(table, 0) + "");
            }
            res.add(list);
        }
        return res;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new MapSolution(),
                "[[\"Table\",\"Beef Burrito\",\"Ceviche\",\"Fried Chicken\",\"Water\"],[\"3\",\"0\",\"2\",\"1\",\"0\"],[\"5\",\"0\",\"1\",\"0\",\"1\"],[\"10\",\"1\",\"0\",\"0\",\"0\"]]",
                "[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]");
    }

    /**
     * TODO 待实现转换工具类
     */
    private static void caseCheck(MapSolution solution, String expected, String s) {
        // CaseAssertUtils.assertEquals(expected, solution.numSubarrayBoundedMax(StructConvertUtils.convertToIntArray(s, ","), left, right));
    }
}
