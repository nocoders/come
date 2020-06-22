package com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_2;

import com.sword.www.algorithms.fourth.algs4.util.SortUtils;
import com.sword.www.algorithms.fourth.algs4.util.StdRandom;

/**
* @Description:    快速排序
* @Author:         linmeng
* @CreateDate:     2020/6/21 18:54
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/21 18:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class QuickSort {

    public static void main(String[] args) {
        Integer[] a = {1,3,45,7,56,65,34,89,99,78,67,46,34,2,25,4,6,7,8,9,8,19,23,56,93,68,35,87,71,56,82,65,74,70,91,93,94,95,96,97,86,46,89,56,48,83,43};
        sort(a);
        System.out.println();
    }
    private static void sort(Comparable[] a){
        if (a==null||a.length<=0){
            throw new IllegalArgumentException("数组不能为空");
        }
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo>=hi){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo,j= hi + 1;
        Comparable v = a[lo];
        while (true){
            while (SortUtils.less(a[++i],v)){
                if (i==hi){
                    break;
                }
            }
            while (SortUtils.less(v, a[--j])){
                if (j==lo){
                    break;
                }
            }
            if (i>=j){
                break;
            }
            SortUtils.swap(a, i, j);
        }
        SortUtils.swap(a, lo, j);

        return j;
    }
}
