package com.sword.www.leetCode.medium;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到
 * 1  2  3  4           1 5 9  13          13 9  5 1
 * 5  6  7  8   ==>>    2 6 10 14 ==>>     14 10 6 2
 * 9  10 11 12  ==>>    3 7 11 15 ==>>     15 11 7 3
 * 13 14 15 16          4 8 12 16          16 12 8 4
 */
public class L_0107 {

    public static void main(String[] args) {
        int [] [] mar = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mar);
        System.out.printf("");
    }
    /**
     * 先用右斜线将左下跟右上进行交换，然后在将左边跟右边进行交换
     * @param matrix 传入数组
     * @author linmeng
     * @date 2020/6/29 15:27
     * @return void
     */
    public static void rotate(int[][] matrix) {
        if (matrix==null){
            return;
        }
        int row = matrix.length;
        int line = matrix[0].length;
        if (row != line){
            return;
        }
        int swap;
        for (int i = 0; i < row; i++) {
            for (int j = i+1; j < line; j++) {
                swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line/2; j++) {
                swap = matrix[i][j];
                matrix[i][j] = matrix[i][line-j-1];
                matrix[i][line-j-1] = swap;
            }
        }
    }
}
