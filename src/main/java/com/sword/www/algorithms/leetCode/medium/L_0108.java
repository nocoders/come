package com.sword.www.algorithms.leetCode.medium;

import java.util.HashSet;

/**
 * 零矩阵，若M × N矩阵中某个元素为0，则将其所在的行与列清零
 *  用两个数组分别记录已经置零的行和列。
 * @author linmeng
 * @version 1.0
 * @date 2020/6/29 21:46
 */
public class L_0108 {

    public static void main(String[] args) {
        int [] [] mar = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(mar);
        System.out.printf("");
    }
    public static void setZeroes(int[][] matrix) {
        if (matrix==null){
            return;
        }
        int row = matrix.length;
        int line = matrix[0].length;
        HashSet<Integer> setZeroOfRow = new HashSet<>();
        HashSet<Integer> setZeroOfLine = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (matrix[i][j] == 0){
                    setZeroOfRow.add(i);
                    setZeroOfLine.add(j);
                }
            }
        }
        for (Integer integer : setZeroOfLine) {
            for (int i = 0; i < row; i++) {
                matrix[i][integer] = 0;
            }
        }
        setZeroOfRow.forEach(integer -> {
            for (int j = 0; j < line; j++) {
                matrix[integer][j] = 0;
            }
        });
    }
}
