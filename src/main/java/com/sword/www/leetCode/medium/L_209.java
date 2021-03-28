package com.sword.www.leetCode.medium;

/**
 *   209. 长度最小的子数组
 *  给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * @author linmeng
 * @version 1.0
 * @date 2020/7/16 14:24
 */
public class L_209 {

    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        int i = minSubArrayLen1(7, nums);
        System.out.println();
    }
    /**
     * 这个题关键是连续这两个字，在数组中找到等于 {@code s} 的连续子数组
     * @param s
     * @param nums
     * @author linmeng
     * @date 2020/7/16 14:26
     * @return int
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int length,tmp ;
        if (nums == null || (length = nums.length) < 1){
            return 0;
        }
        int i ,j,res = Integer.MAX_VALUE;
        for (i = 0; i < length - 1 ; i++) {
            if ((tmp = s - nums[i]) <= 0){
                return 1;
            }
            for (j = i +1; j< length; j++) {
                if ((tmp -=  nums[j])<= 0){
                    res = Math.min(j-i+1,res);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    /**
     * 寻找数组中长度最短的大于target的连续数组
     *  判断数组是否为空，
     *  定义两个指针i=j=0，一个头一个尾，定义sum作为同target判断的元素
     *  sum加j角标下的值。
     *  判断sum是否大于target，大于的话，res=max[res,j-i+1],循环将 sum-nums[i++]
     *  j++
     * @param target
     * @param nums
     * @author linmeng
     * @date 2021年3月28日 10:05
     * @return int
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE,length,i=0,j=i,sum = 0;
        if (nums==null || (length = nums.length)<1){
            return 0;
        }
        while (j<length){
            if (nums[i]>=target){
                return 1;
            }
            sum+=nums[j];
            while (sum>=target){
                res = Math.min(j-i+1,res);
                sum = sum-nums[i++];
            }
            j++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
