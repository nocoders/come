package com.sword.www.algorithms.leetCode.medium;

/**
 *   对角线遍历
 * @date 20200630
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *  见leetCode498.png
 *  解：从0，0开始遍历，遍历条件为i<row,j<line,有两种顺序：一个是往上走的（i-1,j+1),一个是往下走的（i+1,j-1）,
 *      转弯判断：i=0，j+1,开始往下走，j=0,i+1.开始往上走。定义一个boolean变量控制上下方向
 * @date 20200701
 *      昨天想的片面了，导致只有一半数据添加进去就抛异常
 * @author linmeng
 * @version 1.0
 * @date 2020/6/30 21:03
 */
public class L_498 {

    public static void main(String[] args) {
        int [] [] mar = {{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(mar);
        System.out.printf("");
    }
    /**
     *
     *
     * @param matrix
     * @author linmeng
     * @date 2020/6/30 21:22
     * @return int[]
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("传入数组不能为空");
        }
        int row = matrix.length;
        int line = matrix[0].length;
        int[] res = new int[row * line];
        int index = 0;
        // 首次代表是往上的
        boolean direction = true;
        loop: for (int i = 0; ; ) {
            for (int j = 0; ; ) {
                res[index++] = matrix[i][j];

                if (i==0){
                    if (j>=line-1){
                        if (i == row-1 ){
                            break loop;
                        }else {
                            i++;
                            direction = ! direction;
                            continue ;
                        }
                    }else {
                        res[index++] = matrix[i][++j];
                        direction = !direction;
                    }
                }
                if (j==0){
                    if (i >= row-1){
                        if (j == line-1 ){
                            break loop;
                        }else {
                            j++;
                            direction = ! direction;
                            continue ;
                        }
                    }else {
                        res[index++] = matrix[++i][j];
                        direction = !direction;
                    }
                }
                if (direction){
                    i--;
                    j++;
                }else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
