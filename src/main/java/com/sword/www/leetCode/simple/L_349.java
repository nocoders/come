package com.sword.www.leetCode.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @author linmeng
 * @version 1.0
 * @date 2020/8/4 10:34
 */
public class L_349 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
        System.out.println();
    }
    /**
     * 使用HashSet 对一个数组转set，使用set里面的contains方法求交集
     * @param nums1
     * @param nums2
     * @author linmeng
     * @date 2020/8/4 10:40
     * @return int[]
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        return Arrays.stream(nums2).filter(set::contains).distinct().toArray();
    }
}
