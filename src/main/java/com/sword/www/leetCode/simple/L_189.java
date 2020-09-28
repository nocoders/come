package com.sword.www.leetCode.simple;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @author linmeng
 * @version 1.0
 * @date 2020/8/3 13:57
 */
public class L_189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println();
    }
    /**
     * 使用k%nums.length个额外空间
     *
     * @param nums
     * @param k
     * @author linmeng
     * @date 2020/8/3 13:59
     * @return void
     */
    public static void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length <= 1 || k % nums.length == 0){
            return;
        }
        int length = nums.length,len = k % length;
        int[] ints = new int[len];
        // 从开头开始替换
        for (int i = 0; i < len; i++) {
            ints[i] = nums[i];
            nums[i] = nums[length - len + i];
        }
        for (int i = 0; i < length - len; i += len) {
            for (int j = 0; j < len; j++) {
                if (i+len+j>=length){
                    return;
                }
                int tmp = nums[i+len+j];
                nums[i+len+j] = ints[j];
                ints[j] = tmp;
            }
        }
    }
}
