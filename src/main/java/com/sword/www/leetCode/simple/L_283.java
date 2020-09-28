package com.sword.www.leetCode.simple;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/8/5 14:05
 */
public class L_283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println();
    }
    public static void moveZeroes(int[] nums) {
        int i = 0,j = 0,len = nums.length;
        for (;j< len; j++) {
            if (nums[j] != 0){
                nums[i++] = nums[j];
            }
        }
        Arrays.fill(nums,i,len,0);
    }
}
