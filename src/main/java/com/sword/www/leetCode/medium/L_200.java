package com.sword.www.leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年11月24日 10:51
 */
public class L_200 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int i = numIslands2(grid);
        System.out.println();
    }

    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                Queue<Integer> queue = new LinkedList<>();
                if (grid[r][c]=='1'){
                    ++numIslands;
                    grid[r][c]='0';
                    queue.add(r*nc+c);
                    while (!queue.isEmpty()){
                        Integer id = queue.remove();
                        int row = id/nc,col = id%nc;
                        if (row-1>=0 && grid[row-1][col]=='1'){
                            grid[row-1][col]='0';
                            queue.add((row-1)*nc+col);
                        }
                        if (row+1<nr && grid[row+1][col]=='1'){
                            grid[row+1][col]='0';
                            queue.add((row+1)*nc+col);
                        }
                        if (col-1>=0 && grid[row][col-1]=='1'){
                            grid[row][col-1]='0';
                            queue.add(row*nc+col-1);
                        }
                        if (col+1<nc && grid[row][col+1]=='1'){
                            grid[row][col+1]='0';
                            queue.add(row*nc+col+1);
                        }
                    }
                }
            }
        }

        return numIslands;
    }

    public static int numIslands(char[][] grid) {
       if (grid==null || grid.length==0){
           return 0;
       }
       int nr = grid.length,nc = grid[0].length,numIslands=0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j]=='1'){
                    ++numIslands;
                    dfs(grid,i,j);
                }
            }
        }

        return numIslands;
    }

    /**
     * 深度优先搜素查询岛屿数量，遍历数组，看数组元素是否为1，为一递归查询周围元素。为一 置零。把一片1置零后遍历结束
     * @param grid
     * @param r
     * @param c
     * @author linmeng
     * @date 2020年11月24日 11:34
     * @return void
     */
    static void dfs(char[][] grid, int r, int c) {
       if (r<0 || r>=grid.length || c<0 || c>=grid[0].length ||  grid[r][c]=='0'){
           return;
       }
        grid[r][c]='0';
       dfs(grid,r-1,c);
       dfs(grid,r+1,c);
       dfs(grid,r,c+1);
       dfs(grid,r,c-1);
    }
}
