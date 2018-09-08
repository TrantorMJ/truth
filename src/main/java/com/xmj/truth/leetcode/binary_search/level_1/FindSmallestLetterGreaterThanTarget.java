package com.xmj.truth.leetcode.binary_search.level_1;

/**
 * author xiumj
 * create 2018-09-06 09:31
 * desc 寻找比目标字母大的最小字母
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo);
            if (letters[mid] > target) {
                hi = mid - 1;
            } else if (letters[mid] < target) {
                lo = mid + 1;
            } else { // 该字符在数组中
                if (mid != letters.length - 1) {
                    return letters[mid + 1];
                } else {
                    return letters[0];
                }
            }
        }
        if (lo == 0 || lo == letters.length) { // 该字符不在数组中
            return letters[0];
        } else {
            return letters[lo];
        }
    }
}
