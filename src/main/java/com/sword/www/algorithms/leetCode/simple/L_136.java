package com.sword.www.algorithms.leetCode.simple;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author linmeng
 * @version 1.0
 * @date 2020/8/4 9:33
 */
public class L_136 {

    public static void main(String[] args) {
        int [] nums = {2,2,1};
        int i = singleNumber(nums);
        System.out.println();
    }

    /**
     * 除了有一个元素出现过两次，其余元素均出现两次，根据两个相同元素异或等于 0进行处理
     *
     * @param nums
     * @author linmeng
     * @date 2020/8/4 9:33
     * @return int
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num =  num ^ i;
        }
        return num;
    }
}
