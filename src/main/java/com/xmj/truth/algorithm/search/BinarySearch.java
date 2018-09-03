package com.xmj.truth.algorithm.search;

/**
 * author xiumj
 * create 2018-08-30 10:01
 * desc 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) {
                mid = hi - 1;
            } else if (target > nums[mid]) {
                mid = lo + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        int index = binarySearch(nums, 5);
        System.out.println("index = " + index);
    }
}
