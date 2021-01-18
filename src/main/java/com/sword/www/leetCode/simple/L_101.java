package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * @author linmeng
 * @version 1.0
 * @date 2021年1月18日 10:33
 */
public class L_101 {

    /**
     * 迭代判断
     * 定义队列 根节点开始判断，将根节点复制成两份，两个对称的子节点放到一起然后一一对应
     *
     * @param root
     * @author linmeng
     * @date 2021年1月18日 10:50
     * @return boolean
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1==null && node2==null){
                continue;
            }
            if (node1==null || node2==null ||node1.val!=node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

    /**
     * 递归校验是否为对称树
     *
     * @param root
     * @author linmeng
     * @date 2021年1月18日 10:35
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }

        return valid(root.left,root.right);
    }

    private boolean valid(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }

        return valid(left.left,right.right) && valid(left.right,right.left);
    }
}
