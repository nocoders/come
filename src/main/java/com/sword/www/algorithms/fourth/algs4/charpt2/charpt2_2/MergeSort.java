package com.sword.www.algorithms.fourth.algs4.charpt2.charpt2_2;

import com.sword.www.algorithms.fourth.algs4.util.SortUtils;

/**
* @Description:    归并排序:
* @Author:         linmeng
* @CreateDate:     2020/6/21 15:01
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/21 15:01
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class MergeSort {
    public static void main(String[] args) {
        Integer[] a = {1,3,45,7,56,65,34,89,99,78,67,46,34,2,25,4,6,7,8,9,8,19,23,56,93,68,35,87,71,56,82,65,74,70,91,93,94,95,96,97,86,46,89,56,48,83,43};
        sortBu(a);
        System.out.println();
    }
    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        int length = a.length;
        aux = new Comparable[length];
        sort(a,0,length-1);
    }

    /**
     * 对数组进行拆分，直到两个元素拆分成一个元素，就返回。然后将这两个数组进行合并
     * @param a 排序的数组
     * @param lo 排序角标开始位置
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo>=hi){
            return;
        }
        int mid = (lo+hi)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a,lo,mid,hi);
    }

    private static void sortBu(Comparable[] a){
        int N =a.length;
        aux = new Comparable[N];
        for (int i = 1; i < N; i = i + i) {
            for (int lo = 0; lo < N - i; lo+= i) {
                merge(a, lo, lo+i-1, Math.min(lo+i+i-1, N-1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo,j = mid+1;
        // 我们可以在合并前判断第一个数组的最后一个元素同第二个数组的第一个元素的大小，如果前<=后那就不用排序
        if (!SortUtils.less(a[mid],a[mid+1])){
            // 每次两个数组排序好，两个数组合并时，就把之前存入aux里面的数据覆盖掉，因为之前的数据有可能因为排序导致顺序不对
            for (int k = lo; k <= hi ; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi ; k++) {
                if (i>mid){
                    a[k] = aux[j++];
                }else if (j>hi){
                    a[k] = aux[i++];
                }else if (SortUtils.less(aux[i],aux[j])){
                    // 每次只把最小的保存到a数组里面，但是比较用的是aux，这个就不用担心a数组数据覆盖了
                    a[k] = aux[i++];
                }else {
                    a[k] = aux[j++];
                }
            }
        }
    }
}
