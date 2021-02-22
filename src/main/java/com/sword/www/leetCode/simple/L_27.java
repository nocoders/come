package com.sword.www.leetCode.simple;

/**
 * 27 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/16 10:32
 */
public class L_27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        removeElementFx(nums,2);
        System.out.println();
    }
    /**
     * 双指针，定义两个指针，一个指针是用于遍历，另一个指针用来覆盖之前元素，元素同val相同时覆盖
     * @param nums
     * @param val
     * @author linmeng
     * @date 2021年2月22日 09:04
     * @return int
     */
    public static int removeElementFx(int[] nums, int val) {
        int length = nums.length,j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
    /**
     * 将{@code nums}数组里面的元素中跟{@code val} 相等的删除，并把其他元素往前移动，
     * 定义两个指针，一个指针遍历数组，判断是否等于{@code val},另一个指针代表下个修改元素的位置
     *      不等于的话，只把遍历指针加一
     *      等于的话，两个指针同时加一。
     * @param nums
     * @param val
     * @author linmeng
     * @date 2020/7/16 10:34
     * @return int
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0,j=0;
        for (; j < nums.length;) {
            if (nums[j] != val){
                nums[i++] = nums[j++];
            }else {
                j++;
            }
        }
        return i;
    }
}
