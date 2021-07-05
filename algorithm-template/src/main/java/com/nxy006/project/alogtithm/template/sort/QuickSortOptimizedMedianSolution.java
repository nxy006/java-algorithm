package com.nxy006.project.alogtithm.template.sort;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * <b>快速排序（优化：三数取中法）</b>
 * <p>以范围内第一个值为基数，如果恰好该基数是范围内最大/最小值，会导致复杂度降低，本解法为避免此问题，在三个数之间取中间值作为基数</p>
 */
public class QuickSortOptimizedMedianSolution {
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return ;

        int index = partition(nums, low, high);
        quickSort(nums, low, index-1);
        quickSort(nums, index+1, high);
    }

    // low, mid, high     ->     mid < low < high
    private int partition(int[] nums, int low, int high) {
        int mid = low + (high - low) / 2;
        if (nums[low] > nums[high]) swap(nums, low, high);
        if (nums[mid] > nums[high]) swap(nums, mid, high);
        if (nums[mid] > nums[low]) swap(nums, mid, low);

        int pivot = nums[low], start = low;;
        while(low < high) {
            while(low < high && nums[high] >= pivot) { high--; }
            while(low < high && nums[low] <= pivot) { low++; }
            if (low >= high) break;

            swap(nums, low, high);
        }
        swap(nums, start, low);
        return low;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{9, 9, 8, 2, 1, 2, 3, 4, 5, 9});
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{9, 7, 5, 3, 1, 0, 2, 4, 6, 8});
        caseCheck(new QuickSortOptimizedMedianSolution(), new int[]{0, 2, 4, 6, 8, 9, 7, 5, 3, 1});
    }

    private static void caseCheck(QuickSortOptimizedMedianSolution solution, int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        CaseAssertUtils.assertEquals(arrCopy, solution.sort(arr));
    }
}
