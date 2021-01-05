package com.sword.www.leetCode.simple;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月5日 14:26
 */
public class L_215 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        boolean b = containsNearbyDuplicate(nums, 3);
        System.out.println();
    }
    /**
     * 思路整理：感觉这个题的说明比较难理解，指定元素k范围内如果有相同的元素就返回true，否则返回false
     * @param nums
     * @param k 
     * @author linmeng
     * @date 2021年1月5日 16:04
     * @return boolean
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j<len&&j<=i+k; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 遍历数组，定义一个set，判断set中是否包括当前元素
     * 如果包含，直接返回 true，如果不包含，则把当前元素添加到set中，判断set 长度，如果大于k，则移除最开始添加的元素
     * @param nums
     * @param k
     * @author linmeng
     * @date 2021年1月5日 16:32
     * @return boolean
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
