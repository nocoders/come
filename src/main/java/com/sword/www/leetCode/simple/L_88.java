package com.sword.www.leetCode.simple;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 * 提示：
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * @author linmeng
 * @version 1.0
 * @date 21/10/2020 下午2:17
 */
public class L_88 {
    public static void main(String[] args) {
        int[]nums1 = {1,2,3,0,0,0};
        int[]nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }
    /**
     * 使用双指针，从后往前 ，把最大的元素放到最后，这样只有两种情况，
     *      一种是nums1跑完，nums2没跑完，这样需要把nums2剩余元素复制到nums1最前面。
     *      另一种是nums2跑完，nums1没跑完，这样就是正常的
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @author linmeng
     * @date 21/10/2020 下午2:37
     * @return void
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1,q = n-1,r = m+n-1;
        while (p>=0 && q>=0){
            nums1[r--] = nums1[p]>nums2[q] ? nums1[p--] : nums2[q--];
        }
        System.arraycopy(nums1,0,nums1,0,q+1);
    }
}
