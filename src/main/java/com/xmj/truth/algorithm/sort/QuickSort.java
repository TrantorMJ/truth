package com.xmj.truth.algorithm.sort;

import java.util.Arrays;

/**
 * author xiumj
 * create 2018-08-30 19:28
 * desc 快速排序
 */
public class QuickSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi)  // 大小为1的子数组不需要切分
            return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    // 切分算法，快速排序核心算法
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] <= v) {
                if (i == hi)
                    break;
            }
            while (nums[--j] >= v) {
                if (j == lo)
                    break;
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        return j;
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
