package com.sword.www.leetCode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350 两个数组的交集 II
 *  说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author linmeng
 * @version 1.0
 * @date 2020/8/5 9:29
 */
public class L_350 {

    public static void main(String[] args) {
        int []nums1 = {1,2,2,1},nums2 = {2,2};
        int[] intersect = intersect2(nums1, nums2);
        System.out.println();
    }
    /**
     * [1,2,2,1]
     * [2,2]
     * 将两个数组中的长度较短 的数组存入map，map里面数组元素为key，数组数量为value，当前数组元素重复就加1。
     * 遍历另一数组，判断该数组中的元素在map中是否存在，存在的话就将该元素保存到返回数组中
     * @param nums1
     * @param nums2
     * @author linmeng
     * @date 2020/8/5 9:30
     * @return int[]
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
           return intersect(nums2,nums1);
        }else {
            int len1 = nums1.length, len2 =  nums2.length,v,index = 0;
            Map<Integer, Integer> map = new HashMap<>(len1);
            for (int i : nums1) {
                map.put(i,map.getOrDefault(i,0)+1);
            }
            int[] res = new int[len2];
            for (int i : nums2) {
                if ((v = map.getOrDefault(i,0))>0){
                    map.put(i,v-1);
                    res[index++] = i;
                }
            }
            return Arrays.copyOfRange(res,0,index);
        }
    }

    /**
     * 亮点：在不知道哪个数组小的情况下，假定第一个数组小，然后判断是否正确，正确的话继续往下走，
     * 不正确的话就重新调用该方法，把第一个数组作为较小的数组
     * 思路：将两个数组中较小的一个遍历添加到map里面，key为数组的值，value为该值出现的次数。
     * 然后遍历另外一个数组，出现同map重复的元素就保存到返回数组中，并将次数减一
     * @param nums1
     * @param nums2
     * @author linmeng
     * @date 2021年1月5日 14:13
     * @return int[]
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
           return intersect2(nums2,nums1);
           }
        int len1 = nums1.length,len2 = nums2.length,index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < len2; i++) {
            int v;
           if ((v=map.getOrDefault(nums2[i],0))>0){
               map.put(nums2[i],v-1);
               res[index++]=nums2[i];
           }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
