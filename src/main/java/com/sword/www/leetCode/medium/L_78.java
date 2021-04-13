package com.sword.www.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年4月12日 20:42
 */
public class L_78 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsetsDg(new int[]{1, 2, 3});
        System.out.println();
    }

    /**
     * 递归的第一种写法，
     *      最开始定义一个空集合保存到返回结果中，
     *      遍历数组，遍历res，将res中的每一个集合都生成一个新的集合并添加数组中的元素
     *      将生成的新集合 保存到res中
     *
     * @param nums
     * @author linmeng
     * @date 2021年4月12日 21:13
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums==null||nums.length==0){
            return res;
        }
        for (int num : nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            for (List<Integer> re : res) {
                ArrayList<Integer> subList = new ArrayList<>(re);
                subList.add(num);
                lists.add(subList);
            }
            res.addAll(lists);
        }
        return res;
    }
    /**
     * 第二种递归写法，从尾部开始，第n个的子集等于所有的n-1的子集 加上n-1的子集加第n个元素的集合
     * @param nums
     * @author linmeng
     * @date 2021年4月13日 19:13
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> subsetsDg(int[] nums) {

        return recurse(nums.length,nums);
    }

    private static List<List<Integer>> recurse(int n, int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (n==0){
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> existList = recurse(n - 1, nums);
        res.addAll(existList);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> list : existList) {
            ArrayList<Integer> subList = new ArrayList<>(list);
            subList.add(nums[n-1]);
            lists.add(subList);
        }
        res.addAll(lists);
        return res;
    }

}
