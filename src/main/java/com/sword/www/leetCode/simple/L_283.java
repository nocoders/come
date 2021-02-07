package com.sword.www.leetCode.simple;

import java.util.Arrays;

/**
 * 283. 移动零
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
    /**
     * 定义两个指针，
     * 一个指针代表需要填充数据的角标，另一个指针代表当前遍历位置。
     * 一次遍历进行填充。最后将第一个指针后面的元素都填充为0
     * 注：感觉是稍微绕一下的，最开始在想如何获取第一个是0的角标，从这个角标开始进行覆盖。
     *      其实没必要，最开始两个角标相同，只要不为零就覆盖，为0就跳过，这样两个角标就有前后差。说不太清楚，算了
     * @param nums
     * @author linmeng
     * @date 2021年2月7日 16:38
     * @return void
     */
    public static void moveZeroesFx(int[] nums) {
        int length = nums.length,j=0;
        for (int i = 0; i < length; i++) {
            if (nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        Arrays.fill(nums,j,length,0);
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
