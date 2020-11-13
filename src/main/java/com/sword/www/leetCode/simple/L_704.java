package com.sword.www.leetCode.simple;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * @author linmeng
 * @version 1.0
 * @date 13/11/2020 下午2:19
 */
public class L_704 {
    public static void main(String[] args) {
        int []nums = {-1,0,3,5,9,12};
        int search = search(nums, 9);
        System.out.println();
    }
    public static int search(int[] nums, int target) {
        int i=0,j=nums.length,length = nums.length;
        while (i<=j){
            int mid = (i+j+1)/2;
            if (nums[mid]<target){
                i = mid+1;
            }else if (nums[mid]>target){
                j = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
