package com.xmj.truth.leetcode.binary_search.level_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author xiumj
 * create 2018-09-03 19:34
 * desc 两个数组的交集
 */
public class IntersectionOfTwoArrays {

    // 时间复杂度 O(n), 空间复杂度 O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            result[i++] = num;
        }
        return result;
    }

    // 将数组进行排序后，使用双指针
    // 时间复杂度 O(nlgn), 空间复杂度 O(n)
    public int[] intersectionX(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        return result;
    }

    // 将单个数组进行排序后，对另一个数组二分查找
    // 时间复杂度 O(nlgn), 空间复杂度 O(n)
    public int[] intersectionXX(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index++] = num;
        }
        return result;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


}
