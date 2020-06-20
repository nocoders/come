package com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1;

import com.sword.www.algorithms.fourth.algs4.util.SortUtils;

/**
* @Description:    选择排序
* @Author:         linmeng
* @CreateDate:     2020/6/18 21:18
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/18 21:18
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SelectionSort  {

    public static void main(String[] args) {
        Integer[] a = {1,3,45,7,56,65,34,89,99,78,67,46,34,2,25,4,6,7,8,9,8,19,23,56,93,68,35,87,71,56,82,65,74,70,91,93,94,95,96,97,86,46,89,56,48,83,43};
        sort(a);
    }

    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            Comparable min = a[i];
            for (int j = i+1; j < length; j++) {
                if (SortUtils.less(a[j],min)){
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                SortUtils.swap(a,i,minIndex);
            }
        }
    }
}
