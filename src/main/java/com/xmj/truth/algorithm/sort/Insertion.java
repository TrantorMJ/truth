package com.xmj.truth.algorithm.sort;

import com.xmj.truth.algorithm.util.SortUtil;

import java.util.Comparator;

import static com.xmj.truth.algorithm.util.SortUtil.*;

/**
 * author xiumj
 * create 2018-08-13 09:33
 * desc 插入排序
 */
public class Insertion {

    // 该类不能被实例化
    private Insertion() {
    }

    // 使用自然顺序以升序重新排列数组。
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
            assert isSorted(a, 0, 1);
        }
        assert isSorted(a);
    }

    // 使用自然顺序以升序重新排列子数组 a[lo..hi]。
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j++)
                exch(a, j, j - 1);
        }
    }

    // 使用比较器按升序重新排列数组
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j++)
                exch(a, j, j - 1);
            assert isSorted(a, 0, i, comparator);
        }
        assert isSorted(a, comparator);
    }

    // 使用比较器以升序重新排列组数组 a[lo..hi]
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j++)
                exch(a, j, j - 1);
        }
    }

    public static void main(String[] args) {
        String[] a = {"a", "d", "z", "b", "m", "k", "j", "q", "w", "h"};
        SortUtil.Stopwatch stopwatch =  new SortUtil.Stopwatch();
        sort(a);
        System.out.println("elapsedTime = " + stopwatch.elapsedTime());
        show(a);
    }
}
