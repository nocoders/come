package com.sword.www.algorithms.fourth.algs4.util;

/**
* @Description:    文件工具类
* @Author:         linmeng
* @CreateDate:     2020/6/14 22:19
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/14 22:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SortUtils {

    public static boolean less(Comparable<Comparable> v, Comparable w){
        return v.compareTo(w)<0;
    }

    /***
     * @description  数组两个元素交换
     * @author  linmeng
     * @return
     * @exception
     * @date    2020/6/18 21:16
     */
    public static void swap(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
