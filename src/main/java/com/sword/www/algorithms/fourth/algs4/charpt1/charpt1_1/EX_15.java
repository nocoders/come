package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;
/**
* @Description:    计算
* @Author:         linmeng
* @CreateDate:     2020/6/16 10:47
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/16 10:47
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class EX_15 {

    public static void main(String[] args) {
        int[] a = {1,3,45,7,56,65,34,89,99,78,67,45,34,2,3,4,6,7,8,9,8,19,23,56,93,67,35,87,7,56,82,65,74,74,91,93,94,95,96,97,86,46,89,56,48,83,43};
        int[] histogram = histogram(a, 100);
        System.out.println();
    }
    public static int[] histogram(int [] a,int M){
        int [] res = new int[M];
        for (int i : a) {
            res[i] = res[i]+1;
        }
        return res;
    }
}
