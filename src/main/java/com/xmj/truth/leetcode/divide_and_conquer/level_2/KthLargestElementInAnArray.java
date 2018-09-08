package com.xmj.truth.leetcode.divide_and_conquer.level_2;

/**
 * author xiumj
 * create 2018-08-29 10:24
 * desc 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class KthLargestElementInAnArray {

    private static int[] aux;

    public static int findKthLargest(int[] nums, int k) {
        mergeSort(nums);
        return nums[k-1];
    }

    private static void mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
        /*int k = lo;
        while (k <= hi) {
            if (i > mid) {
                nums[k++] = aux[j++];
            } else if (j > hi) {
                nums[k++] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
            }
        }
        */
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //int[] nums = {3, 2, 1, 5, 6, 4};
        //int[] nums = {1, 2};
        int result = findKthLargest(nums, 4);
        System.out.println("result = " + result);
    }
}
