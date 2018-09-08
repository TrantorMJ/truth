package com.xmj.truth.leetcode.binary_search.level_1;

/**
 * author xiumj
 * create 2018-09-03 19:23
 * desc 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值
 */
public class PeakIndexInAMountainArray {

    public static int peakIndexInMountainArray(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                lo = mid + 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
