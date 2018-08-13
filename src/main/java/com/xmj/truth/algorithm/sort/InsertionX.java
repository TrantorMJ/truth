package com.xmj.truth.algorithm.sort;

import com.xmj.truth.algorithm.util.SortUtil;

import static com.xmj.truth.algorithm.util.SortUtil.less;
import static com.xmj.truth.algorithm.util.SortUtil.show;

/**
 * author xiumj
 * create 2018-08-13 10:37
 * desc 不需要交换的插入排序
 * 在内循环中将较大的元素都向右移动问不是总是交换两个元素（使较大元素右移一位只需要访问一次数组，这样访问数组的次数就能减半）
 */
public class InsertionX {

    private InsertionX() {
    }

    public static void sortIntro(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable key = a[i];
            int j = i - 1;
            while (j >= 0 && less(key, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable key = a[i];
            int j;
            for (j = i - 1; j >= 0 && less(key, a[j]); j--)
                a[j + 1] = a[j];
            a[j + 1] = key;
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {

    }

    public static void main(String[] args) {
        String[] a = {"a", "d", "z", "b", "m", "k", "j", "q", "w", "h"};
        SortUtil.Stopwatch stopwatch =  new SortUtil.Stopwatch();
        sort(a);
        System.out.println("elapsedTime = " + stopwatch.elapsedTime());
        show(a);
    }
}
