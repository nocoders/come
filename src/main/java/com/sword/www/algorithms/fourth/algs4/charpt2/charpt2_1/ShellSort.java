package com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1;

import com.sword.www.algorithms.fourth.algs4.util.SortUtils;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] a = {1,3,45,7,56,65,34,89,99,78,67,46,34,2,25,4,6,7,8,9,8,19,23,56,93,68,35,87,71,56,82,65,74,70,91,93,94,95,96,97,86,46,89,56,48,83,43};
        sort(a);
        System.out.println();
    }
    public static void  sort(Comparable[] a){
        // 最大长度数组设置为3，求最大的数组长度
        int length = a.length;
        int h =1;
        while (h<length/3){
            h = 3* h + 1;
        }
        while (h>=1){
            // 外层循环是遍历后面的每个元素的
            for (int i = h;i<length;i++){
                // 内层循环判断后面的元素是否比 前面的小，比前面的小就一直往后走
                for (int j = i; j >= h && SortUtils.less(a[j],a[j-h]); j-=h) {
                    SortUtils.swap(a,j,j-h);
                }
            }
            // 修改h长度
            h = h /3;
        }
    }
}
