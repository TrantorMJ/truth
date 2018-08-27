package com.xmj.truth.leetcode.divide_and_conquer.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * author xiumj
 * create 2018-08-25 10:10
 * desc 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class MajorityElement {

    /******************************** 暴力破解 *************************/
    public int majorityElementByBruteForce(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int ele : nums) {
                if (ele == num) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    /******************************** 哈希表 *************************/
    public int majorityElementByHashMap(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            /* 1
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
            */

            /* 2
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num) + 1);
            */

            /* 3
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            */

            counts.merge(num, 1, Integer::sum);
        }
        return counts;
    }

    /******************************** 分治法 *************************/

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (num == nums[i]) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi)
            return nums[lo];
        int mid = lo + (hi - lo) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if (left == right)
            return left;
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public int majorityElementByDivideAndConquer(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    /******************************** awesome *************************/

    public int majorityElementAwesome(int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
