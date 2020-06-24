package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

public class EX_11 {

    public static void main(String[] args) {
        boolean[][] a = {{true,false,true,true,false,false,true,true,true,false}
                ,{false,true,true,true,false,false,true,true,true,true}
                ,{false,false,true,false,false,false,true,false,true,false}
                ,{true,true,true,true,true,false,true,false,false,true}
                ,{true,false,true,true,false,true,false,true,true,false}};
        printArray(a);
    }
    public static void printArray(boolean[][] a){
        int row = a.length;
        int line = a[0].length;
        System.out.print(" ");
        for (int i = 0; i < line; i++) {
            System.out.print(" "+(i+1));
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < line; j++) {
                System.out.print(a[i][j]?"* ":"  ");
            }
            System.out.println();
        }
    }
}
