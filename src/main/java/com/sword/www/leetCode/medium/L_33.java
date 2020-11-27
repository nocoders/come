package com.sword.www.leetCode.medium;

/**
 * 33. 搜索旋转排序数组
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 * [6，7，8，9,1,2,3,4]
 * @author linmeng
 * @version 1.0
 * @date 16/11/2020 下午4:42
 */
public class L_33 {

    public static void main(String[] args) {
        int [] a = {3,1};
        int search = search(a, 1);
        System.out.println();
    }
    public static int search(int[] nums, int target) {
        int length = nums.length,l=0,r=length-1;
        if (length==1){
            return nums[0]==target?0:-1;
        }
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target){
                return mid;
            }
            // 判断中间的数是否大于第一个元素，大于第一个元素说明左边是有序的，否则右边有序
            if (nums[mid]>=nums[0]){
                // 判断target 是否大于等于最小的数，并小于中位数
                if (target>=nums[0] && target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                // 右边有序，判断值是否在右边范围内
                if (target<=nums[r] && target>nums[mid]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }

        return -1;
    }
}
