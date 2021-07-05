package com.nxy006.project.alogtithm.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StructConvertUtils {
    private static final String INT_MATRIX_CONVERT_PATTERN =
            "^\\[\\s*\\[\\s*\\d+(\\s*,\\s*\\d+)*\\s*](\\s*,\\s*\\[\\s*\\d+(\\s*,\\s*\\d+)*\\s*\\])*\\s*\\]$";

    public static List<String> convertToStringList(String s) {
        return convertToStringList(s, " ");
    }

    public static List<String> convertToStringList(String s, String separator) {
        String[] arr = s.split(separator);
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static int[] convertToIntArray(String s, String separator) {
        String[] arr = s.split(separator);
        return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
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
}
