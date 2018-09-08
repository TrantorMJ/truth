package com.xmj.truth.leetcode.binary_search.level_1;

/**
 * author xiumj
 * create 2018-09-05 11:05
 * desc 搜索插入位置
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
