package com.sword.www.util;

/**
 * 快速排序
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年2月25日 17:23
 */
public class QuickSelectUtil {

    public static void main(String[] args) {
        Integer[] nums = {5,6,3,2,1,4,6,8,9,12,31,65,77,81,19};
        sort(nums);
        System.out.println();
    }
    public static void sort(Integer [] nums){
        Shuffle.arrayShuffle(nums);
        sort(nums,0,nums.length-1);
    }

    /**
     * 数组顺序随机打乱
     * 数组切分，数组制定范围内的第一个元素作为切分元素
     * 进行切分，从左边开始，使用while获取左边比切分元素大的角标，
     *          从右边开始，使用while获取右边比切分元素小的角标
     *          两者进行交换
     *          当左边角标比右边角标大时，循环结束，
     *          将切分元素同同较小的那个元素j进行交换
     *          切分结束，将j返回
     * 递归进行排序，使用lo，j-1 j+1，hi
     * @param nums
     * @param lo
     * @param hi
     * @author linmeng
     * @date 2021年3月5日 09:02
     * @return void
     */
    private static void sort(Integer[] nums, int lo, int hi) {
        if (hi<=lo){
            return;
        }
        int j = partition(nums,lo,hi);
        sort(nums,lo,j-1);
        sort(nums,j+1,hi);
    }

    /**
     * 两个指针指向左右两侧，循环获取左侧比指定元素大的，右侧比指定元素小的两者进行交换
     * 最后将第一个元素同中间元素进行交换
     *
     * @param nums
     * @param lo
     * @param hi
     * @author linmeng
     * @date 2021年3月3日 15:56
     * @return int
     */
    private static int partition(Integer[] nums, int lo, int hi) {
        int i=lo,j=hi+1;
        int val = nums[lo];
        for (;;){
            while (less(nums[++i],val)){
                if (i==hi){
                    break;
                }
            }
            while (less(val,nums[--j])){
                if (j==lo){
                    break;
                }
            }
            if (i>=j){
                break;
            }
            exch(nums,i,j);
        }
         exch(nums,lo,j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}