package com.sword.www.algorithms.leetCode.simple;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020/7/16 11:02
 */
public class L_485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println();
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0,tmp = 0,length;
        if (nums == null || (length = nums.length)<1){
            return res;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] == 1){
                tmp++;
            }else {
                res = Math.max(res,tmp);
                tmp = 0;
            }
        }

        return Math.max(res,tmp);
    }
}
