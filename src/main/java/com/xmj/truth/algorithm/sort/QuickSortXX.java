package com.xmj.truth.algorithm.sort;

import java.util.Arrays;

/**
 * author xiumj
 * create 2018-08-31 19:34
 * desc 三向切分的快速排序
 */
public class QuickSortXX {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        int sentinel = nums[lo];
        while (i <= gt) {
            if (nums[i] < sentinel) {
                exch(nums, lt++, i++);
            } else if (nums[i] > sentinel) {
                exch(nums, gt--, i);
            } else {
                i++;
            }
        }
        sort(nums, lo, lt - 1);
        sort(nums, gt + 1, hi);
    }

    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9, 5, 8, 5, 7, 6, 5, 5, 4, 5, 3, 5, 2, 1};
        sort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
    }
}
