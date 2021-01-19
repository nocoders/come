package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.TreeNode;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @author linmeng
 * @version 1.0
 * @date 2021年1月19日 08:42
 */
public class L_112 {

    /**
     * 当前节点到叶子节点路径的和等于sum,
     * 使用递归进行处理，递归结束的条件是target等于0或节点为空
     *
     * @param root
     * @param sum
     * @author linmeng
     * @date 2021年1月19日 08:59
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        int target = sum - root.val;
        if ((target==0 && root.left==null && root.right==null) ||hasPathSum(root.right,target) || hasPathSum(root.left,target)){
            return true;
        }

        return false;
    }
}
