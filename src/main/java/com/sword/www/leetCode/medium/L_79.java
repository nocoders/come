package com.sword.www.leetCode.medium;

import java.util.Arrays;

/**
 * word2.jpg
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 *
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年4月13日 19:20
 */
public class L_79 {

    public static void main(String[] args) {
        String word = "SEE";
        char[][]board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean b = new L_79().exist(board, word);
        System.out.println();
    }
    /** 二维字符网格 **/
    char[][]board;
    /** 查找的字符数组，将{@code word}转换为字符数组  **/
    char[] ws;
    /** 目前已经使用的字符角标 **/
    boolean[][]used;
    /** 前后左右，用于计算下一个元素 **/
    int[][]direction={{0,-1},{0,1},{-1,0},{1,0}};
    int row,line;

    /**
     * 使用递归对board进行深度优先搜索，将递归时搜索的每一个元素同对应{@code word}中的元素进行比较，看是否相等，相等就继续往下走
     * @param board 二维字符数组，用于判断数组中有没有相连的字符串
     * @param word 字符串
     * @author linmeng
     * @date 2021年5月7日 14:51
     * @return boolean
     */
    public boolean exist(char[][] board, String word) {
        this.row=board.length;
        this.line=board[0].length;
        this.board=board;
        ws = word.toCharArray();
        used=new boolean[row][line];
        for (int i = 0; i < row; i++) {
            Arrays.fill(used[i],false);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (board[i][j]==ws[0]){
                    used[i][j]=true;
                    if (dfs(i,j,1)){
                        return true;
                    }else {
                        used[i][j]=false;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index==ws.length){
            return true;
        }
        for (int[] ints : direction) {
            int newI = i+ints[0],newJ=j+ints[1];
            // 判断角标是否越界，角标是否被使用
            if (newI<0 || newJ<0 || newI>=row || newJ >=line  || used[newI][newJ]){
                continue;
            }
            if (board[newI][newJ]==ws[index]){
                used[newI][newJ]=true;
                // 找到结果返回true，找不到将当前使用元素置为false
                if (dfs(newI,newJ,index+1)){
                    return true;
                }
                used[newI][newJ]=false;
            }
        }

        return false;
    }
}
