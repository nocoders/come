package com.sword.www.algorithms.fourth.algs4.charpt1_1;

public class EX_13 {

    public static void main(String[] args) {
        int[][] a = {{1,0,1,1,0,0,1,1,1,0}
                ,{0,1,1,1,0,0,1,1,1,1}
                ,{0,0,1,0,0,0,1,0,1,0}
                ,{1,1,1,1,1,0,1,0,0,1}
                ,{1,0,1,1,0,1,0,1,1,0}};
        rowLineTransfer(a);
    }
    /***
    * @description 行列互换
    * @author  linmeng
    * @return
    * @exception
    * @date    2020/6/16 10:05
    */
    public static void rowLineTransfer(int[][]a){
        int row = a.length;
        int line = a[0].length;
        for (int i = 0; i < row; i++) {
            System.out.print(" "+(i+1));
        }
        System.out.println();
        for (int i = 0; i < line; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < row; j++) {
                System.out.print(a[j][i]+" ");
            }
            System.out.println();
        }
    }
}
