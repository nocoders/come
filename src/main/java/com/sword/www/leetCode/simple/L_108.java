package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author linmeng
 * @version 1.0
 * @date 19/10/2020 上午11:11
 */
public class L_108 {

    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println();
    }
    public static TreeNode sortedArrayToBST(int[] nums) {

        return arrayTransferToNode(nums,0,nums.length-1);
    }

    public static TreeNode arrayTransferToNode(int[] arrays,int left,int right){
        if (left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(arrays[mid]);
        root.left = arrayTransferToNode(arrays,left,mid-1);
        root.right = arrayTransferToNode(arrays,mid+1,right);

        return root;
    }
}
