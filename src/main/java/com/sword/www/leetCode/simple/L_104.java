package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @author linmeng
 * @version 1.0
 * @date 2021年1月18日 09:12
 */
public class L_104 {

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{3,9,20,null,null,15,7};
        TreeNode node = TreeNode.arrayTransferToNode(arrays, 0);
        int i = maxDepthBFS(node);
        System.out.println();
    }
    /**
     * 深度优先搜索获取深度。
     *
     * @param root
     * @author linmeng
     * @date 2021年1月18日 09:13
     * @return int
     */
    public int maxDepthDFS(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepthDFS(root.left),maxDepthDFS(root.right))+1;
    }
    /**
     * 广度优先搜索:从根节点开始，将每层的节点全都放到队列中，取出当层节点，把下一层子节点放到队列中。
     *      直到队列为空
     *
     * @param root
     * @author linmeng
     * @date 2021年1月18日 09:17
     * @return int
     */
    public static int maxDepthBFS(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res++;
        }

        return res;
    }
}
