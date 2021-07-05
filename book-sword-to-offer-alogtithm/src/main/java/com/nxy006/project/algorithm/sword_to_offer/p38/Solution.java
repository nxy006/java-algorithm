package com.nxy006.project.algorithm.sword_to_offer.p38;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;
import com.nxy006.project.alogtithm.utils.StructConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> AllPermutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        List<String> res = new ArrayList<>();
        res.add(new String(arr));
        while((arr = nextPermutation(arr)) != null) {
            res.add(new String(arr));
        }
        return res;
    }

    private char[] nextPermutation(char[] arr) {
        for(int i = arr.length-1; i > 0; i--) {
            if (arr[i-1] < arr[i]) {
                for(int j = arr.length-1; j >= i; j--) {
                    if (arr[i-1] < arr[j] && arr[j-1] != arr[j]) {
                        char temp = arr[j];
                        arr[j] = arr[i-1];
                        arr[i-1] = temp;
                        Arrays.sort(arr, i, arr.length);
                        return arr;
                    }
                }
            }
        }
        return null;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new Solution(), "aaaaa", "aaaaa");
        caseCheck(new Solution(), "abc,acb,bac,bca,cab,cba", "abc");
        caseCheck(new Solution(), "aab,aba,baa", "aab");
    }

    private static void caseCheck(Solution solution, String expected, String s) {
        CaseAssertUtils.assertEqualsIgnoreOrder(StructConvertUtils.convertToStringList(expected, ","), solution.AllPermutation(s));
    }
}
