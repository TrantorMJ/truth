package com.xmj.truth.leetcode.divide_and_conquer.level2;

/**
 * author xiumj
 * create 2018-08-30 09:41
 * desc 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {  //检测数组输入
            return false;
        }
        int loX = 0, loY = 0;
        int hiX = matrix.length - 1, hiY = matrix[0].length - 1;
        return searchMatrix(matrix, loX, hiX, loY, hiY, target);
    }

    private static boolean searchMatrix(int[][] matrix, int loX, int hiX, int loY, int hiY, int target) {
        while (loX <= hiX && loY <= hiY) {
            int midX = loX + (hiX - loX);
            int midY = loY + (hiY - loY);
            int middle = matrix[midX][midY];
            if (middle == target) { // 二维矩阵中间值为目标值
                return true;
            } else if (middle > target) { // 二维矩阵中间值大于目标值，目标值位于左上角、左下角、右上角矩阵中
                boolean leftUp = searchMatrix(matrix, loX, midX - 1, loY, midY - 1, target);
                boolean leftDown = searchMatrix(matrix, midX, hiX, loY, midY - 1, target);
                boolean rightUp = searchMatrix(matrix, loX, midX - 1, midY, hiY, target);
                return leftUp || rightUp || leftDown;
            } else { // 二维矩阵中间值小于目标值，目标值位于左下角、右上角、右下角矩阵中
                boolean rightDown = searchMatrix(matrix, midX + 1, hiX, midY + 1, hiY, target);
                boolean rightUp = searchMatrix(matrix, loX, midX, midY + 1, hiY, target);
                boolean leftDown = searchMatrix(matrix, midX + 1, hiX, loY, midY, target);
                return rightDown || rightUp || leftDown;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean result = searchMatrix(matrix, 20);
        System.out.println("result = " + result);
    }
}
