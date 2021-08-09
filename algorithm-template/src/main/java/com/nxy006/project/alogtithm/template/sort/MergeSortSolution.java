package com.nxy006.project.alogtithm.template.sort;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * <b>归并排序</b>
 * <p>递归排序和合并数组，其处理过程是自下到上的，先处理子问题，然后再合并</p>
 * <p><b>归并排序在任何情况下时间复杂度都比较稳定，但归并排序并非原地排序算法，空间复杂度较高，使用没有快速排序广泛<b/></p>
 *
 * <br/>
 * <p>稳定的排序</p>
 * <p>最优/最差/平均时间复杂度：O(nlogn)，执行效率与待排序的数组的已有顺序无关</p>
 * <p>空间复杂度：O(n)</p>
 */
public class MergeSortSolution {
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return ;
        }

        // 递归拆分为子问题执行排序
        int mid = l + (r-l)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    // 将两个已排序的数组合并为新的数组
    public void merge(int[] nums, int l, int mid, int r) {
        int[] tempArr = new int[r-l+1];

        int j = l, k = mid+1;
        for(int i = 0; i < tempArr.length; i++) {
            // 注意：这里使用 <= 比较大小才能保证排序是稳定的
            if (k > r || j <= mid && nums[j] <= nums[k]) {
                tempArr[i] = nums[j++];
            } else {
                tempArr[i] = nums[k++];
            }
        }

        System.arraycopy(tempArr, 0, nums, l, tempArr.length);
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new MergeSortSolution(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        caseCheck(new MergeSortSolution(), new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        caseCheck(new MergeSortSolution(), new int[]{9, 9, 8, 2, 1, 2, 3, 4, 5, 9});
        caseCheck(new MergeSortSolution(), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        caseCheck(new MergeSortSolution(), new int[]{9, 7, 5, 3, 1, 0, 2, 4, 6, 8});
        caseCheck(new MergeSortSolution(), new int[]{0, 2, 4, 6, 8, 9, 7, 5, 3, 1});
    }

    private static void caseCheck(MergeSortSolution solution, int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        CaseAssertUtils.assertEquals(arrCopy, solution.sort(arr));
    }
}
