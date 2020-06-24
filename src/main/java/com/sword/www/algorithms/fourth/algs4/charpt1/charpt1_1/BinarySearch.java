package com.sword.www.algorithms.fourth.algs4.charpt1.charpt1_1;

import java.util.Arrays;

/**
* @Description:     二分法寻找元素(递归）
* @Author:         linmeng
* @CreateDate:     2020/6/14 22:08
* @UpdateUser:     linmeng
* @UpdateDate:     2020/6/14 22:08
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BinarySearch {

    public static void main(String[] args) throws Exception {
        int [] a = {2,3,234,45,2,354,34,213,45,234,234,6,4,678,96,970,7875,657,4563,54234,2345,325325,5467,4,46787};
        Arrays.sort(a);
        int index = rank(657, a);
        System.out.println(index);
    }
    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length-1);
    }

    private static int rank(int key, int[] a, int low, int high) {
        if (low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if (a[mid]>key){
            return rank(key,a,low,mid-1);
        }else if (a[mid]<key){
            return rank(key,a,mid+1,high);
        }else {
            return mid;
        }
    }
}
