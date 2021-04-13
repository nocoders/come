package com.sword.www.leetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author linmeng
 * @version 1.0
 * @date 2021年4月8日 22:13
 */
public class L_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        L_16 l_16 = new L_16();
        List<List<Integer>> permute = l_16.permute(nums);
        System.out.println();
    }
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0){
            return res;
        }
        backTrack(res,nums,0,nums.length, new LinkedList<>());

        return res;
    }

    private void backTrack(ArrayList<List<Integer>> res, int[] nums, int i, int length, LinkedList<Integer> list) {
        if (i==length){
            res.add(new ArrayList<>(list));
        }else {
            for (int j = 0; j < nums.length; j++) {
                if (list.contains(nums[j])){
                    continue;
                }
                list.add(nums[j]);
                backTrack(res,nums,i+1,length,list);
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> permuteFx(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0){
            return res;
        }
       backTrackFx(res,nums,0,nums.length-1,new LinkedList<Integer>());

        return res;
    }

    private void backTrackFx(ArrayList<List<Integer>> res,int[] nums, int i, int length, LinkedList<Integer> list) {
        if (i==length){
            res.add(list);
        }
        for (int j = i; j < length; j++) {
            if (list.contains(nums[j])){
                continue;
            }
            list.add(nums[j]);
            backTrackFx(res, nums, i+1, length, list);
            list.removeLast();
        }
    }
}
