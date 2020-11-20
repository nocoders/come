package com.sword.www.leetCode.medium;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 * @author linmeng
 * @version 1.0
 * @date 18/11/2020 上午10:08
 */
public class L_162 {

    /**
     * 三种情况：
     *      1：一直降序，第一个元素就是峰值
     *      2：一直升序，最后一个元素时峰值
     *      3：先升后降 那
     *
     * @param nums
     * @author linmeng
     * @date 18/11/2020 上午10:13
     * @return int
     */
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if (nums[i]>nums[i+1]){
                return i;
            }
        }
        return length-1;
    }
}
