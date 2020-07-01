package com.sword.www.algorithms.leetCode.medium;

/**
 *   对角线遍历
 * @TODO 这道题我放弃，以后再搞
 * @date 20200630
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *  见leetCode498.png
 *  解：从0，0开始遍历，遍历条件为i<row,j<line,有两种顺序：一个是往上走的（i-1,j+1),一个是往下走的（i+1,j-1）,
 *      转弯判断：i=0，j+1,开始往下走，j=0,i+1.开始往上走。定义一个boolean变量控制上下方向
 * @date 20200701
 *      昨天想的片面了，导致只有一半数据添加进去就抛异常。
 *      首先，往上走，往下走这个是有问题的
 *      开始的时候，i=0,j+1 开始往下走；j=0,i+1.开始往上走，这个转弯条件是i=0,或j=0,或i=row-1,或j=line-1
 *      转弯后角标变化，i+1,或j+1有个布尔类型数据控制，这个布尔类型每次转弯都取反，
 *      只有两个情况不取反：i=0,j=line-1或i=row-1,j=0
 * @author linmeng
 * @version 1.0
 * @date 2020/6/30 21:03
 * @update 2020/7/1 16:00
 */
public class L_498 {

    public static void main(String[] args) {
        int [] [] mar = {{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(mar);
        System.out.print("");
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
        int resLength = row * line;
        int[] res = new int[resLength];
        int index = 0;
        // 首次代表是往上的
        boolean direction = true;
        int indexOfRow = 0,indexOfLine = 0;
        for (int i = 0; i < resLength; ) {
            res[i++] = matrix[indexOfRow][indexOfLine];
            // 判断是否需要转向
            if (indexOfRow == 0){
                if (indexOfLine<line-1){
                    direction = ! direction;
                    indexOfLine++;
                }else if (indexOfLine == line-1){
                    indexOfRow++;
                }else {
                    break;
                }
            }
            if (indexOfLine == 0){
                if (indexOfRow<row-1){
                    direction = ! direction;
                    indexOfRow++;
                }else if (indexOfRow == row-1){
                    indexOfLine++;
                }
            }
            res[i++] = matrix[indexOfRow][indexOfLine];
            if (direction){
                indexOfRow--;
                indexOfLine++;
            }else {
                indexOfRow++;
                indexOfLine--;
            }
        }
//        loop: for (int i = 0; ; ) {
//            for (int j = 0; ; ) {
//                res[index++] = matrix[i][j];
//
//                if (i==0){
//                    if (j>=line-1){
//                        if (i == row-1 ){
//                            break loop;
//                        }else {
//                            i++;
//                            direction = ! direction;
//                            continue ;
//                        }
//                    }else {
//                        res[index++] = matrix[i][++j];
//                        direction = !direction;
//                    }
//                }
//                if (j==0){
//                    if (i >= row-1){
//                        if (j == line-1 ){
//                            break loop;
//                        }else {
//                            j++;
//                            direction = ! direction;
//                            continue ;
//                        }
//                    }else {
//                        res[index++] = matrix[++i][j];
//                        direction = !direction;
//                    }
//                }
//                if (direction){
//                    i--;
//                    j++;
//                }else {
//                    i++;
//                    j--;
//                }
//            }
//        }
        return res;
    }
}
