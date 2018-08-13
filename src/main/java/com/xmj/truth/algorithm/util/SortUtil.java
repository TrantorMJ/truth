package com.xmj.truth.algorithm.util;

import java.util.Comparator;

/**
 * author xiumj
 * create 2018-08-13 09:35
 * desc 排序工具类
 */
public class SortUtil {

    /****************************************************
     * 辅助函数
     * *************************************************/

    // v < w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // v < w ?
    public static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // 交换a[i] 和 a[j]
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // 交换a [i]和[j]（用于间接排序）
    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /****************************************************
     * 检查是否有序 - 用于debug
     * *************************************************/

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    // 数组a[lo..hi]是否有序
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(i, i - 1))
                return false;
        return true;
    }

    public static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    // 数组a[lo..hi]是否有序
    public static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator))
                return false;
        return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }


    // 计时器
    public static class Stopwatch {

        private final long startTime;

        public Stopwatch() {
            this.startTime = System.currentTimeMillis();
        }

        public double elapsedTime() { // elapsed [ɪ'læpst]
            long endTime = System.currentTimeMillis();
            return (endTime - startTime) / 1000.0;
        }
    }
}
