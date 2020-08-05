package com.sword.www.algorithms.leetCode.simple;

import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @author linmeng
 * @version 1.0
 * @date 2020/8/5 14:27
 */
public class L_1 {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};

        int[] ints = twoSum(nums, 9);
        System.out.println();


    }
    /**
     * 两数之和，返回 等于target的两数之和的下标
     *  思路：看的leetcode上面的，我是想不到的，这辈子都想不到的，哈哈
     *  使用的特性是散列表特性，遍历数组，存入散列表，key为元素值，value为元素角标，
     *  先判断散列表中有没有target-元素对应的key，有直接返回，没有就把该元素加入散列表。
     *
     *  这个有个地方我想的不是太明白，但是感觉也明白一点，就是 最精髓的为什么判断存在和加入 hash表一次遍历就完成，但是感觉也没啥毛病
     * @param nums
     * @param target
     * @author linmeng
     * @date 2020/8/5 14:27
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
