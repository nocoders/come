package com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_1;
import com.sword.www.algorithms.fourth.algs4.util.SortUtils;

public class InsertSort {
    public static void main(String[] args) {
        Integer[] a = {1,3,45,7,56,65,34,89,99,78,67,46,34,2,25,4,6,7,8,9,8,19,23,56,93,68,35,87,71,56,82,65,74,70,91,93,94,95,96,97,86,46,89,56,48,83,43};
        sort(a);
    }
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && SortUtils.less(a[j],a[j-1]); j--) {
                SortUtils.swap(a,j-1,j);
            }
        }
    }
}
