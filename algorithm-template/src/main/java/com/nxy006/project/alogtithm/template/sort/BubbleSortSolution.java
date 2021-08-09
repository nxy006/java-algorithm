package com.nxy006.project.alogtithm.template.sort;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * <b>冒泡排序</b>
 * <p>不断交换顺序不正确的相邻元素，在这个过程中每轮执行会把当前未排序的最大值移动到后方的正确位置，因而叫冒泡排序</p>
 * <p><b>冒泡排序与插入排序复杂度相同，但因为冒泡的每次交换需要 3 次操作，而插入排序每次移动仅需 1 次操作，不推荐使用冒泡排序<b/></p>
 *
 * <br/>
 * <p>原地排序，稳定的排序</p>
 * <p>最优时间复杂度：O(n)，即数据已经有序的情况</p>
 * <p>最差时间复杂度：O(n^2)，即数组恰好为倒序的情况</p>
 * <p>平均时间复杂度：O(n^2) </p>
 */
public class BubbleSortSolution {
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // 如果不能原地操作，则需要前复制原数组
        // int[] arr = Arrays.copyOf(nums, nums.length);

        // 外层循环用于控制轮次，不参与比较和交换
        for(int i = 0; i < nums.length; i++) {
            boolean flag = false;

            // 内存循环每次从头交换到到处 i 个位置（最后 i 个位置已经有序，无需判断）
            for(int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            // 如果某轮检查未发生任何交换，说明数组已经有序，可以跳过后续循环
            if (!flag) {
                break;
            }
        }
        return nums;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new BubbleSortSolution(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        caseCheck(new BubbleSortSolution(), new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        caseCheck(new BubbleSortSolution(), new int[]{9, 9, 8, 2, 1, 2, 3, 4, 5, 9});
        caseCheck(new BubbleSortSolution(), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        caseCheck(new BubbleSortSolution(), new int[]{9, 7, 5, 3, 1, 0, 2, 4, 6, 8});
        caseCheck(new BubbleSortSolution(), new int[]{0, 2, 4, 6, 8, 9, 7, 5, 3, 1});
    }

    private static void caseCheck(BubbleSortSolution solution, int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        CaseAssertUtils.assertEquals(arrCopy, solution.sort(arr));
    }
}
