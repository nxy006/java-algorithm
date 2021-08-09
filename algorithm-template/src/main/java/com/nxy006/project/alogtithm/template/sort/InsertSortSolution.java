package com.nxy006.project.alogtithm.template.sort;

import com.nxy006.project.alogtithm.utils.CaseAssertUtils;

import java.util.Arrays;

/**
 * <b>插入排序</b>
 * <p>将数组视为已排序和未排序两部分，每次取一个未排序的值插入到已排序范围</p>
 *
 * <br/>
 * <p>原地排序，稳定的排序</p>
 * <p>最优时间复杂度：O(n)，即数据已经有序的情况</p>
 * <p>最差时间复杂度：O(n^2)，即数组恰好为倒序的情况</p>
 * <p>平均时间复杂度：O(n^2) </p>
 */
public class InsertSortSolution {
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        // 如果不能原地操作，则需要前复制原数组
        // int[] arr = Arrays.copyOf(nums, nums.length);

        // 外层循环用于表示要本轮要插入值的位置 i，同时也表示了有序范围 [0, i-1]
        for(int i = 1; i < nums.length; i++) {
            int value = nums[i];

            // 注意，在有序范围内遍历时要从后向前遍历，这样遍历的好处有;
            // 1. 如果数组已经有序则每轮 O(1) 复杂度即可判断
            // 2. 遍历时可以同时完成比较与交换
            int j = i-1;
            for(; j >= 0; j--) {
                if (value < nums[j]) {
                    nums[j+1] = nums[j];
                } else {
                    // 注意：不能在这里执行插入操作
                    // 如果遇到当前插入的值为最小值，遍历完整个范围都没找到位置，写在这里将导致无法执行 nums[0] 插入操作
                    break;
                }
            }
            // 执行插入操作
            nums[j+1] = value;
        }
        return nums;
    }

    // ---------------------------------------------------------- TEST CASE ----------------------------------------------------------- //

    public static void main(String[] args) {
        caseCheck(new InsertSortSolution(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        caseCheck(new InsertSortSolution(), new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        caseCheck(new InsertSortSolution(), new int[]{9, 9, 8, 2, 1, 2, 3, 4, 5, 9});
        caseCheck(new InsertSortSolution(), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        caseCheck(new InsertSortSolution(), new int[]{9, 7, 5, 3, 1, 0, 2, 4, 6, 8});
        caseCheck(new InsertSortSolution(), new int[]{0, 2, 4, 6, 8, 9, 7, 5, 3, 1});
    }

    private static void caseCheck(InsertSortSolution solution, int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        CaseAssertUtils.assertEquals(arrCopy, solution.sort(arr));
    }
}
