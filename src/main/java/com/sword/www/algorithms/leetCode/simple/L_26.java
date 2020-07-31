package com.sword.www.algorithms.leetCode.simple;

/**
 * 删除排序数组中的重复项
 *给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/31 16:11
 */
public class L_26 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    /**
     * 原地修改数组，并返回数组的新长度 。
     * 双指针，一个是元素遍历位置，一个是元素修改位置
     * 判断元素是否重复根据的是上一次替换的元素同该元素是否相同，相同即为重复
     * @param nums
     * @author linmeng
     * @date 2020/7/31 16:14
     * @return int 元素新长度
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null  ||  nums.length == 0){
            return 0;
        }
        int modifyIndex = 0,index,length = nums.length;
        for (index = 0; index < length; index++) {
            if (nums[modifyIndex] != nums[index]){
                nums[++modifyIndex] = nums[index];
            }
        }
        return modifyIndex+1;
    }
}
