package com.sword.www.leetCode.simple;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author linmeng
 * @version 1.0
 * @date 3/11/2020 下午5:00
 */
public class L_53 {

    /**
     * 最大子序和：遍历时将和放到sum里面，另外有一个变量保存res作为返回结果，
     * 如果sum小于0时就抛弃，比较res跟sum。
     * @param nums
     * @author linmeng
     * @date 4/11/2020 上午8:50
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int sum = 0 ,res = nums[0];
        for (int num : nums) {
            sum = sum>0 ? sum+num : num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
