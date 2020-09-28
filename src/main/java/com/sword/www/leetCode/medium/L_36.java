package com.sword.www.leetCode.medium;

import java.util.HashMap;

/**
 * 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * @author linmeng
 * @version 1.0
 * @date 2020/8/5 15:08
 */
public class L_36 {

    public static void main(String[] args) {
        char[][] sudo =  {
                {'8','3','8','.','9','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'.','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku = isValidSudoku(sudo);
        System.out.println();
    }
    /**
     * 判断数独中已经存在的数字是否有效：同行，同列以及在3X3的方格中都是唯一。
     * 个人思路：（看了官方题解出现的思路）盗版
     *  定义三个map数组 ，分别存储同行，同列，3X3方格中的元素，
     *  先判断这三个数组中包不包括遍历所在元素，包括直接返回false，不包括就把该元素加入以上数组的元素中
     *  注：重点是判断元素所在的子数独（3X3方格）在map数组中的角标：(row / 3) * 3 + columns / 3
     *
     * @param board
     * @author linmeng
     * @date 2020/8/5 15:12
     * @return boolean
     */
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9],lines = new HashMap[9],boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(16);
            lines[i] = new HashMap<>(16);
            boxes[i] = new HashMap<>(16);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int boxIndex = i/3*3 + j/3;
                int tmp = board[i][j] - '0';
                if (tmp >= 1 && tmp<= 9){
                    if (rows[i].containsKey(tmp) || lines[j].containsKey(tmp) || boxes[boxIndex].containsKey(tmp)){
                        return false;
                    }
                    rows[i].put(tmp,rows[i].getOrDefault(tmp,0)+1);
                    lines[j].put(tmp,lines[j].getOrDefault(tmp,0)+1);
                    boxes[boxIndex].put(tmp,boxes[boxIndex].getOrDefault(tmp,0)+1);
                }
            }
        }
        return true;
    }
}
