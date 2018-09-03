package com.xmj.truth.algorithm.sort;

import java.util.Arrays;

/**
 * author xiumj
 * create 2018-08-31 11:06
 * desc 快速排序算法改进
 * 将取样元素放在数组的末尾作为哨兵来去掉切分算法中的数组边界测试
 */
public class QuickSortX {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int sentinel = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= sentinel) {
                exch(nums, ++i, j);
            }
        }
        exch(nums, ++i, hi);
        return i;
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }
}
