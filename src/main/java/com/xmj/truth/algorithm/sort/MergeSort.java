package com.xmj.truth.algorithm.sort;

import static com.xmj.truth.algorithm.util.SortUtil.less;

/**
 * author xiumj
 * create 2018-08-20 09:10
 * desc 归并排序
 */
public class MergeSort {

    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // 一次性分配空间
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid + 1, hi); // 将右边排序
        merge(a, lo, mid, hi); // 归并结果
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;
        for (int k = lo; i <= hi; k++) { // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
