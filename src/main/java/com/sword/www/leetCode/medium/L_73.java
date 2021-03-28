package com.sword.www.leetCode.medium;

import java.util.HashSet;

/**
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 * 示例 1：
 *
 *mat1.jpg
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *mat2.jpg
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年3月28日 21:00
 */
public class L_73 {

    public static void main(String[] args) {
        int [][]matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println();
    }
    /**
     * 把等于0的行和列都变成0
     * 用两个set保存等于0的行和列，遍历数组，判断该数组有没有在set中，没有的话等于0就 添加到set中
     *
     * @param matrix
     * @author linmeng
     * @date 2021年3月28日 21:03
     * @return void
     */
    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length,lineLength = matrix[0].length;
        HashSet<Integer> rowSet = new HashSet<>(rowLength);
        HashSet<Integer> lineSet = new HashSet<>(lineLength);
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < lineLength; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    lineSet.add(j);
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            if (rowSet.contains(i)) {
                for (int k = 0; k < lineLength; k++) {
                    matrix[i][k]=0;
                }
            }
            for (int j = 0; j < lineLength; j++) {
                if (lineSet.contains(j)){
                    for (int k = 0; k < rowLength; k++) {
                        matrix[k][j]=0;
                    }
                }

            }
        }
    }
}
