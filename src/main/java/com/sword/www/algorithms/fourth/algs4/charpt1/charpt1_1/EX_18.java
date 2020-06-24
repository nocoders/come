package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

public class EX_18 {

    public static void main(String[] args) {
        int mystery = mystery2(3, 11);
        System.out.println();
    }
    /***
    * @description 求积
    * @author  linmeng
    * @date    2020/6/16 16:45
    */
    public static int mystery(int a ,int b){
        if (b==0){
            return 0;
        }
        if (b%2==0){
            return mystery(a+a,b/2);
        }
        return mystery(a+a,b/2)+a;
    }

    public static int mystery2(int a,int b){
        if (b==0){
            return 1;
        }
        if (b%2==0){
            return mystery2(a*a,b/2);
        }
        return mystery2(a*a,b/2)*a;
    }
}
