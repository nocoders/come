package com.sword.www.leetCode.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author linmeng
 * @version 1.0
 * @date 2021年2月23日 10:47
 */
public class L_215 {

    private static Random random= new Random();;

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int kthLargest = findKthLargest2(nums, 2);
        System.out.println(kthLargest);
    }
    /**
     * 使用最笨的方法，排序
     * @param nums
     * @param k
     * @author linmeng
     * @date 2021年2月23日 10:53
     * @return int
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 使用快速排序算法，对数组进行分区，分区后判断第K个元素在哪一区，然后再对该区进行分区
     * @param nums
     * @param k
     * @author linmeng
     * @date 2021年3月23日 15:31
     * @return int
     */
    public static int findKthLargest2(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int l, int r, int k) {
        int index = partition(nums,l,r);

        if (index==k){
            return nums[index];
        }else {
            return index < k ? quickSelect(nums, index + 1, r, k) : quickSelect(nums, l, index - 1, k);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        int x=random.nextInt(r-l+1)+l;
        swap(nums,x,r);
        int i=l-1,val = nums[r];
        for (int j = l; j < r; j++) {
            if (nums[j]<val){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,r);

        return i+1;
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
