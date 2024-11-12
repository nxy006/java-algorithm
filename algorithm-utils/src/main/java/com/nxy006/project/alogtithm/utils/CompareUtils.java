package com.nxy006.project.alogtithm.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareUtils {
    public static boolean assertEqualsCommon(Object expected, Object actual) {
        if (expected instanceof Double && actual instanceof Double) {
            return assertEquals(((Double) expected).doubleValue(), ((Double) actual).doubleValue());
        }
        return assertEquals(expected, actual);
    }

    public static boolean assertEquals(double expected, double actual) {
        return assertEquals(expected, actual, 1e-10);
    }

    public static boolean assertEquals(double expected, double actual, double epsilon) {
        // double 因精度问题，比较大小时要支持容忍范围
        return Math.abs(expected - actual) <= epsilon;
    }

    public static boolean assertEquals(Object expected, Object actual) {
        return expected != null && expected.equals(actual);
    }

    public static <T> boolean compare(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null || list2 == null || list1.size() != list2.size()) return false;

        for(int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    // TODO 此排序有疏漏，不能应对重复值，比如 [1,2,2] 与 [1,1,2] 会误判为相等
    public static <T> boolean compareIgnoreOrder(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null || list2 == null || list1.size() != list2.size()) return false;

        return new HashSet<T>(list1).equals(new HashSet<>(list2));
    }
}
