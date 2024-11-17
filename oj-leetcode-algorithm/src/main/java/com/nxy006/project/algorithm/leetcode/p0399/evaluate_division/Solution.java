package com.nxy006.project.algorithm.leetcode.p0399.evaluate_division;

import java.util.*;

/**
 * 未完成解法
 */
public class Solution extends SolutionTemplate {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> biggerMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String bigger = values[i] > 1 ? equation.get(0) : equation.get(1);
            String smaller = values[i] > 1 ? equation.get(1) : equation.get(0);
            set.add(bigger);
            set.add(smaller);

            List<String> list = biggerMap.getOrDefault(bigger, new ArrayList<>());
            list.add(smaller);
            biggerMap.put(bigger, list);
        }

        Map<String, Double> valueMap = new HashMap<>();
        for(String start : set) {
            String minVariable = findMinVariable(biggerMap, start);
            valueMap.put(minVariable, 1.0);
        }

        while(valueMap.size() < set.size()) {
            for(int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);

                String a = equation.get(0), b = equation.get(1);
                if (valueMap.get(b) != null) {
                    valueMap.put(a, valueMap.get(b) * values[i]);
                } else if (valueMap.get(a) != null) {
                    valueMap.put(b, valueMap.get(a) / values[i]);
                }
            }
        }

        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (!valueMap.containsKey(query.get(0)) || !valueMap.containsKey(query.get(1))) {
                result[i] = -1.0d;
            } else {
                result[i] = valueMap.get(query.get(0)) / valueMap.get(query.get(1));
            }
        }
        return result;
    }

    private String findMinVariable(Map<String, List<String>> biggerMap, String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        while(!queue.isEmpty()) {
            String variable = queue.poll();
            if (biggerMap.get(variable) == null) {
                return variable;
            } else {
                for(String nextVariable : biggerMap.get(variable)) {
                    if (!set.contains(nextVariable)) {
                        queue.offer(nextVariable);
                        set.add(nextVariable);
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        processCaseTest(new Solution());
    }
}
