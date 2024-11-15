package com.nxy006.project.alogtithm.utils;

import com.nxy006.project.alogtithm.utils.struct.ListNode;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrettyPrintUtils {
    public static String toPrettyString(Object object) {
        // 数组类型
        if (object instanceof int[]) {
            return toPrettyString(Arrays.stream((int[]) object).boxed().collect(Collectors.toList()));
        } else if (object instanceof long[]) {
            return toPrettyString(Arrays.stream((long[]) object).boxed().collect(Collectors.toList()));
        } else if (object instanceof double[]) {
            return toPrettyString(Arrays.stream((double[]) object).boxed().collect(Collectors.toList()));
        } else if (object.getClass().isArray()) {
            return toPrettyString(Arrays.stream((Object[]) object).collect(Collectors.toList()));
        }

        // 基本类型
        if (object instanceof ListNode) {
            return toPrettyString((ListNode) object);
        } else if (object instanceof TreeNode) {
            return toPrettyString((TreeNode) object);
        }
        return object.toString();
    }

    public static String toPrettyString(List<Object> list) {
        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = toPrettyString(list.get(i));
        }
        return "[" + String.join(",", result) + "]";
    }

    public static String toPrettyString(ListNode listNode) {
        return listNode.toString();
    }

    public static String toPrettyString(TreeNode treeNode) {
        return treeNode.toString();
    }
}
