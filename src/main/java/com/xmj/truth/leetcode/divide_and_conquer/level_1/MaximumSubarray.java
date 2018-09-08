package com.xmj.truth.leetcode.divide_and_conquer.level_1;

/**
 * author xiumj
 * create 2018-08-27 09:44
 * desc 最大子序和
 */
public class MaximumSubarray {

    public static int findMaximumSubarray(int[] nums, int lo, int hi) {
        if (lo == hi)
            return nums[lo];
        int mid = lo + (hi - lo) / 2;
        int leftResult = findMaximumSubarray(nums, lo, mid);
        int rightResult = findMaximumSubarray(nums, mid + 1, hi);
        int crossResult = findMaxCrossingSubarray(nums, lo, mid, hi);
        if (leftResult >= rightResult && leftResult >= crossResult) {
            return leftResult;
        } else if (rightResult >= leftResult && rightResult >= crossResult) {
            return rightResult;
        } else {
            return crossResult;
        }
    }

    private static int findMaxCrossingSubarray(int[] nums, int lo, int mid, int hi) {
        int leftSum = 0, sum = 0, leftIndex = mid;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }

        int rightSum = 0, rightIndex = mid;
        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += nums[j];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = j;
            }
        }
        return leftSum + rightSum;
    }

    private static class Result {
        private int lo;
        private int hi;
        private int sum;

        public Result(int lo, int hi, int sum) {
            this.lo = lo;
            this.hi = hi;
            this.sum = sum;
        }

        public int getLo() {
            return lo;
        }

        public int getHi() {
            return hi;
        }

        public int getSum() {
            return sum;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "lo=" + lo +
                    ", hi=" + hi +
                    ", sum=" + sum +
                    '}';
        }
    }

    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int result = findMaximumSubarray(nums, 0, nums.length - 1);
        System.out.println("result = " + result);
    }
}
