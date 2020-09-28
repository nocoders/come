package com.sword.www.leetCode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
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
        int[] intersect = intersect(nums1, nums2);
        System.out.println();
    }
    /**
     * [1,2,2,1]
     * [2,2]
     * 将两个数组中的长度较短 的数组存入map，map里面数组元素为key，数组数量为value。
     * 遍历另一数组，若map中该元素数量大于0则保存 到返回数组中，并把map中该元素数量减一。
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
}
