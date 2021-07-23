package com.nxy006.project.alogtithm.utils;

import com.nxy006.project.alogtithm.utils.struct.ListNode;
import com.nxy006.project.alogtithm.utils.struct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StructConvertUtils {
    private static final String INT_ARRAY_CONVERT_PATTERN =
            "^\\[\\s*[-]?\\d+(\\s*,\\s*[-]?\\d+)*\\s*\\]$";
    private static final String STRING_ARRAY_CONVERT_PATTERN =
            "^\\[\\s*\\S.*\\S(\\s*,\\s*\\S.*\\S)*\\s*\\]$";
    private static final String INT_MATRIX_CONVERT_PATTERN =
            "^\\[\\s*\\[\\s*\\d+(\\s*,\\s*\\d+)*\\s*](\\s*,\\s*\\[\\s*\\d+(\\s*,\\s*\\d+)*\\s*\\])*\\s*\\]$";
    private static final String STRING_MATRIX_CONVERT_PATTERN =
            "^\\[\\s*\\[\\s*\\S(.*\\S)*(\\s*,\\s*\\S(.*\\S)*)*\\s*](\\s*,\\s*\\[\\s*\\S(.*\\S)*(\\s*,\\s*\\S(.*\\S)*)*\\s*\\])*\\s*\\]$";

    private static final String NULL_STR = "null";
    private static final String EMPTY_INT_ARRAY = "[]";
    private static final String EMPTY_MATRIX = "[[]]";

    private static final Converter<String> stringConverter = s -> s.replaceAll("(^\"|\"$)", "");
    private static final Converter<Character> characterConverter = s -> s.replaceAll("(^\"|\"$)", "").charAt(0);
    private static final Converter<Integer> integerConverter = s -> Integer.valueOf(s.replaceAll("(^\"|\"$)", ""));

    // Array 数组相关------------------------------------------------------------------------------------------------------------------- //

    public static int[] convertToIntArray(String s) {
        if (EMPTY_INT_ARRAY.equals(s)) {
            return new int[]{};
        }
        if (!Pattern.matches(INT_ARRAY_CONVERT_PATTERN, s)) {
            throw new IllegalArgumentException("cannot convert to int array, Input string format error: " + s);
        }

        String[] SArr = s.replaceAll("\\s", "").replaceAll("[\\[\\]]", "").split(",");
        return Arrays.stream(SArr).mapToInt(Integer::valueOf).toArray();
    }

    @Deprecated
    public static int[] convertToIntArray(String s, String separator) {
        String[] arr = s.split(separator);
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    public static String[] convertToStringArray(String s) {
        String[] arr = convertToOriginStringArray(s);
        for(int i = 0; i < arr.length; i++) {
            arr[i] = stringConverter.convertTo(arr[i]);
        }
        return arr;
    }

    /**
     * 将给定字符串转换为二维整数数组
     *
     * <p/>允许以下格式：
     * <ol>
     *   <li>[[100]]</li>
     *   <li>[[100,200]]</li>
     *   <li>[[100,200],[50]]</li>
     *   <li>[[100,200],[50,80]]</li>
     * </ol>
     *
     * @param s 字符串
     * @return 二维数组
     */
    public static int[][] convertToIntMatrix(String s) {
        if (EMPTY_INT_ARRAY.equals(s) || EMPTY_MATRIX.equals(s)) {
            return new int[][]{};
        }
        if (!Pattern.matches(INT_MATRIX_CONVERT_PATTERN, s)) {
            throw new IllegalArgumentException("cannot convert to matrix, Input string format error: " + s);
        }

        // 1. 用 ],[ 内容将原字符串分割为多段
        String[] SArr = s.replaceAll("\\s", "").split("(\\],\\[)");
        int[][] matrix = new int[SArr.length][];
        for(int i = 0; i < SArr.length; i++) {
            // 2. 将第一步隔开的字符串，删除所有 [] 符号，并用 , 分割
            String[] SNum = SArr[i].replaceAll("[\\[\\]]", "").split(",");

            // 3. 逐个转换为数字
            int[] matrixRow = new int[SNum.length];
            for(int j = 0; j < SNum.length; j++) {
                matrixRow[j] = Integer.parseInt(SNum[j]);
            }
            matrix[i] = matrixRow;
        }
        return matrix;
    }

    public static char[][] convertToCharMatrix(String s) {
        String[][] originMatrix = convertToOriginStringMatrix(s);
        char[][] matrix = new char[originMatrix.length][originMatrix[0].length];
        for(int i = 0; i < originMatrix.length; i++) {
            for(int j = 0; j < originMatrix[i].length; j++) {
                matrix[i][j] = characterConverter.convertTo(originMatrix[i][j]);
            }
        }
        return matrix;
    }

    public static String[][] convertToStringMatrix(String s) {
        String[][] matrix = convertToOriginStringMatrix(s);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = stringConverter.convertTo(matrix[i][j]);
            }
        }
        return matrix;
    }

    // List 容器相关 ------------------------------------------------------------------------------------------------------------------- //

    public static List<Integer> convertToIntegerList(String s) {
        return convertToList(s, integerConverter);
    }

    public static List<String> convertToStringList(String s) {
        return convertToList(s, stringConverter);
    }

    @Deprecated
    public static List<String> convertToStringList(String s, String separator) {
        String[] arr = s.split(separator);
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static <T> List<T> convertToList(String s, Converter<T> converter) {
        String[] arr = convertToOriginStringArray(s);
        List<T> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            res.add(converter.convertTo(arr[i]));
        }
        return res;
    }

    public static List<List<String>> convertToStringNestedList(String s) {
        return convertToNestedList(s, stringConverter);
    }

    public static List<List<Integer>> convertToIntegerNestedList(String s) {
        return convertToNestedList(s, integerConverter);
    }

    public static <T> List<List<T>> convertToNestedList(String s, Converter<T> converter) {
        String[][] matrix = convertToOriginStringMatrix(s);
        List<List<T>> res = new ArrayList<>(matrix.length);

        for(String[] arr : matrix) {
            // 对类似 [[], [1]] 的输入，将第一个子列表转换为空列表
            if (arr.length == 0 || arr.length == 1 && "".equals(arr[0])) {
                res.add(new ArrayList<>());
                continue;
            }
            List<T> list = new ArrayList<>(arr.length);
            for(String str : arr) {
                list.add(converter.convertTo(str));
            }
            res.add(list);
        }
        return res;
    }

    // ListNode 单向链表相关 ----------------------------------------------------------------------------------------------------------- //

    public static ListNode convertToListNode(String s) {
        if (NULL_STR.equals(s) || EMPTY_INT_ARRAY.equals(s)) return null;
        return convertToListNode(convertToIntArray(s));
    }

    public static ListNode convertToListNode(int[] arr) {
        ListNode res = new ListNode(0), node = res;
        for (int num : arr) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return res.next;
    }

    // TreeNode 二叉树相关 ------------------------------------------------------------------------------------------------------------- //

    // TODO 尚未实现
    public static TreeNode convertToTreeNode(String s) {
        return new TreeNode(0);
    }

    // 私有方法 ------------------------------------------------------------------------------------------------------------------------ //

    /**
     * 仅供内部调用：此方法只做简单结构检查和切分，未做数据转换
     */
    private static String[][] convertToOriginStringMatrix(String s) {
        if (EMPTY_MATRIX.equals(s)) {
            return new String[][]{};
        }
        if (!Pattern.matches(STRING_MATRIX_CONVERT_PATTERN, s)) {
            throw new IllegalArgumentException("cannot convert to matrix, Input string format error: " + s);
        }

        // 1. 用 ],[ 内容将原字符串分割为多段
        String[] SArr = s.replaceAll("\\s", "").split("(\\],\\[)");
        String[][] matrix = new String[SArr.length][];
        for(int i = 0; i < SArr.length; i++) {
            // 2. 将第一步隔开的字符串，删除所有 [] 符号，并用 , 分割
            matrix[i] = SArr[i].replaceAll("[\\[\\]]", "").split(",");
        }
        return matrix;
    }

    /**
     * 仅供内部调用：此方法只做简单结构检查和切分，未做数据转换
     */
    private static String[] convertToOriginStringArray(String s) {
        if (EMPTY_INT_ARRAY.equals(s)) {
            return new String[]{};
        }
        if (!Pattern.matches(STRING_ARRAY_CONVERT_PATTERN, s)) {
            throw new IllegalArgumentException("cannot convert to int array, Input string format error: " + s);
        }

        return s.replaceAll("\\s", "").replaceAll("[\\[\\]]", "").split(",");
    }

    private interface Converter<T> {
        T convertTo(String s);
    }
}
