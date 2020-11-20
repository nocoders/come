package com.sword.www.leetCode.medium;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @author linmeng
 * @version 1.0
 * @date 18/11/2020 下午5:27
 */
public class L_34 {

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int[] ints = searchRange(nums, 2);

        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length<1){
            return new int[]{-1,-1};
        }
        int leftIndex = searchLeft(nums, target);
        int rightIndex = leftIndex;
        if (leftIndex>=0){
           while (rightIndex<length-1){
               if (nums[rightIndex+1]==target){
                   rightIndex++;
               }else {
                   break;
               }
           }
           return new int[]{leftIndex,rightIndex};
        }

        return new int[]{-1,-1};
    }

    public static int searchLeft(int[] nums, int target){
        int l = 0,length = nums.length,r = length-1,mid;
        while (l<r){
            mid = l + (r-l)/2;
            if (nums[mid]>=target){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        if (nums[r]==target){
            return r;
        }

        return -1;
    }
}
