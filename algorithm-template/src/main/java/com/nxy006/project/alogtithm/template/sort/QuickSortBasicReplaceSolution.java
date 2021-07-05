package com.nxy006.project.alogtithm.template.sort;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * <b>快速排序（写法一：替换）</b>
 * <p>以范围内第一个值为基数替换，将数组划分为两块</p>
 */
public class QuickSortBasicReplaceSolution {
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return ;

        int index = partition(nums, start, end);
        quickSort(nums, start, index-1);
        quickSort(nums, index+1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while(start < end) {
            while(start < end && nums[end] >= pivot) {
                end--;
            }
            if (start < end) nums[start] = nums[end];

            while(start < end && nums[start] <= pivot) {
                start++;
            }
            if (start < end) nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{9, 9, 8, 2, 1, 2, 3, 4, 5, 9});
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{9, 7, 5, 3, 1, 0, 2, 4, 6, 8});
        caseCheck(new QuickSortBasicReplaceSolution(), new int[]{0, 2, 4, 6, 8, 9, 7, 5, 3, 1});
    }

    private static void caseCheck(QuickSortBasicReplaceSolution solution, int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        CaseAssertUtils.assertEquals(arrCopy, solution.sort(arr));
    }
}
