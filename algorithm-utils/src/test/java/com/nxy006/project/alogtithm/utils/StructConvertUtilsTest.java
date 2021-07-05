package com.nxy006.project.alogtithm.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StructConvertUtilsTest {

    @Test
    void convertToIntMatrix() {
        // Valid Input
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[[100]]"), new int[][]{{100}});
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[[100,200]]"), new int[][]{{100, 200}});
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[[100,200],[50]]"), new int[][]{{100, 200}, {50}});
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[[100,200],[50,80]]"), new int[][]{{100, 200}, {50, 80}});
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[[100, 200], [50, 80]]"), new int[][]{{100, 200}, {50, 80}});
        Assertions.assertArrayEquals(StructConvertUtils.convertToIntMatrix("[ [ 100 , 200 ] , [ 50 , 80 ] ]"), new int[][]{{100, 200}, {50, 80}});

        // Invalid Input
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[][]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[[]]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[100]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[[10 0]]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[100,[100,200]]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[[1][2],[3]]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix("[[2.568]]"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StructConvertUtils.convertToIntMatrix(" [[100]] "));
    }
}