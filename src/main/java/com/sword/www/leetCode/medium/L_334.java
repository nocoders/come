package com.sword.www.leetCode.medium;

/**
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * 示例 3：
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 * 提示：
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 * @author linmeng
 * @version 1.0
 * @date 2021年3月29日 21:36
 */
public class L_334 {

    public static void main(String[] args) {
        int [] nums = {1,2,1,4,2};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE,two = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num>two){
                return true;
            }else if (num<=one){
                one=num;
            }else {
                two=num;
            }
        }
        return false;
    }
        /**
         * ERROR
         *
         * @param nums
         * @author linmeng
         * @date 2021年3月29日 21:54
         * @return boolean
         */
    public static boolean increasingTriplet2(int[] nums) {
        int length;
        if (nums==null || (length=nums.length)<3){
            return false;
        }
        int i=0,j=1,k=2;
        while (k<length){
            if (nums[i]<nums[j]){
                if (nums[j]<nums[k]){
                    return true;
                }else {
                    i=k;
                    j=k+1;
                    k=k+2;
                }
            }else {
                i=j;
                j=k;
                k++;
            }
        }
        return false;
    }
}
