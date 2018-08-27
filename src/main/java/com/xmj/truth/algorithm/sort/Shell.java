package com.xmj.truth.algorithm.sort;

import static com.xmj.truth.algorithm.util.SortUtil.less;
import static com.xmj.truth.algorithm.util.SortUtil.show;

/**
 * author xiumj
 * create 2018-08-14 20:38
 * desc 希尔排序
 */
public class Shell {

    private Shell() {
    }

    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3)
            h = 3 * h + 1;
        System.out.println("h = " + h);
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                Comparable key = a[i];
                int j;
                for (j = i - h; j >= 0 && less(key, a[j]); j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = key;
            }
            show(a);
            System.out.println();
            h /= 3;
        }
    }

    public static void main(String[] args) {
        //String[] a = {"a", "d", "z", "b", "m", "k", "j", "q", "w", "h"};
        String[] a = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
    }
}
