package com.sword.www.leetCode.medium;

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
 * @date 20200728 我又回来了
 *      这次回来不一样了，是看了题解回来的。
 *      反正就是 一直判断，一直debug,不过最后还是失败了
 * @date 20200730
 *      https://leetcode-cn.com/problems/diagonal-traverse/solution/javajie-ti-by-ailurusfulgens/
 *      换了个题解，之前做的都太复杂了 ，这个简单。
 *      方向有左上，右下两种。这两种分别有两种越界方式。
 *      左上有两种越界方式，一种是上边越界，一种是右边越界，上边越界 indexOfRow + 1，右边越界 indexOfLine 重置为line-1，
 *  indexOfRow + 2
 *      右下有两种越界方式，一种是下边越界，一种是左边越界，左边越界 indexOfLine + 1，下边越界 indexOfRow 重置为row-1，
 *  indexOfLine + 2
 * @author linmeng
 * @version 1.0
 * @date 2020/6/30 21:03
 * @update 2020/7/1 16:00
 */
public class L_498 {

    public static void main(String[] args) {
        int [] [] mar = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(mar);
        System.out.print("");
    }
    /**
     * {@code direction} 代表方向，true代表向上走，i--,j++,false 代表往下走，i++,j--
     * 边界判断：边界判断判断条件 i<0,i>row-1,j<0,j>line-1
     *
     * @param matrix
     * @author linmeng
     * @date 2020/6/30 21:22
     * @return int[]
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int line = matrix[0].length;
        int resLength = row * line;
        int[] res = new int[resLength];
        // 首次代表是往上的
        boolean direction = true;
        int indexOfRow = 0, indexOfLine = 0;
        for (int i = 0; i < resLength; ) {
            res[i++] = matrix[indexOfRow][indexOfLine];
            // 1、对两个角标进行加减
            if (direction) {
                indexOfRow--;
                indexOfLine++;
                // 改变两个元素的放到上面，防止下面的置零后，上面的重复加2，出现问题
                if (indexOfLine > line - 1) {
                    indexOfLine = line - 1;
                    indexOfRow += 2;
                    direction = false;
                }
                if (indexOfRow < 0) {
                    indexOfRow = 0;
                    direction = false;
                }

            } else {
                indexOfRow++;
                indexOfLine--;
                if (indexOfRow > row - 1) {
                    indexOfRow = row - 1;
                    indexOfLine += 2;
                    direction = true;
                }
                if (indexOfLine < 0) {
                    indexOfLine = 0;
                    direction = true;
                }

            }
        }
        return res;
    }
}
