package com.xmj.truth.leetcode.binary_search.level_1;

/**
 * author xiumj
 * create 2018-09-06 09:46
 * desc 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) // 输入为1
            return true;
        int lo = 0;
        int hi = num;
        int mid;
        while (true) {
            mid = lo + (hi - lo) / 2;
            int product = mid * mid;
            while (product < 0) { // 乘积超过整数可表示范围
                mid = lo + (mid - lo) / 2;
                product = mid * mid;
            }
            if (mid != lo) {
                if (product > num) {
                    hi = mid;
                } else if (product < num) {
                    lo = mid;
                } else {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 2147395600;
        boolean result = isPerfectSquare(num);
        System.out.println("result = " + result);
        System.out.println("1073697800*1073697800 = " + 1073697800*1073697800);
    }
}
