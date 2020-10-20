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

    public TreeNode sortedArrayToBST(int[] nums) {

        return arrayTransferToNode(nums,0);
    }

    public static TreeNode arrayTransferToNode(int[] arrays,int index){
        TreeNode tn = null;
        if (index < arrays.length){
            int value = arrays[index];
            tn = new TreeNode(value);
            tn.left = arrayTransferToNode(arrays,2*index+1);
            tn.right = arrayTransferToNode(arrays,2*index+2);

            return tn;
        }

        return tn;
    }
}
