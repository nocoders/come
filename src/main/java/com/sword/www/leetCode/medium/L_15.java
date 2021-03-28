package com.sword.www.leetCode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @author linmeng
 * @version 1.0
 * @date 2021年3月28日 11:20
 */
public class L_15 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0};
        List<List<Integer>> lists = threeSum2(nums);
        System.out.println(lists.toString());
    }
    /**
     * 三数之和，并且不能重复
     * 首先对数组进行排序
     * 遍历数组，获取target = nums[i]
     * 再次遍历数组，使用两个指针，若两个指针之和减去target等于0，加入返回数组。因为数组是顺序的之后的元素就不需要遍历了
     * @param nums
     * @author linmeng
     * @date 2021年3月28日 11:22
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length ;
        if (nums==null || (length=nums.length)<3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1 ; j++) {
                for (int k = j+1; k < length ; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        while (i+1<length-2 &&nums[i]==nums[i+1]){
                            i++;
                        }
                        while (j<length-2 && nums[j]==nums[j+1]){
                            j++;
                        }
                        while (k<length-1 && nums[k]==nums[k+1]){
                            k++;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 排序，排序后左右窗口滑动
     *
     * @param nums
     * @author linmeng
     * @date 2021年3月28日 19:13
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length;
        if (nums == null || (length = nums.length) < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 2;i++) {
            while (i>0 && i<length && nums[i]==nums[i-1]){
                i++;
            }
            int j=i+1,k=length-1;
            while (j<k){
                int tmp = nums[j]+nums[k]+nums[i];
                if (tmp==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while (j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }else {
                    if (tmp<0){
                        j++;
                        while (j<k && nums[j]==nums[j-1]){
                            j++;
                        }
                    }
                    if (tmp>0){
                        k--;
                        while (j<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                }
            }

        }
        return res;
    }
}
