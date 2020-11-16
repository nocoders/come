package com.sword.www.leetCode.medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 * 输入：nums = [1]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数都是 唯一 的
 * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
 * @author linmeng
 * @version 1.0
 * @date 16/11/2020 下午3:50
 */
public class L_153 {

    public int findMin(int[] nums) {
        int left = 0,length = nums.length,right = length-1;
        if (length==1){
            return nums[0];
        }
        if (nums[0]<nums[length-1]){
            return nums[0];
        }
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if (nums[mid]>nums[0]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
