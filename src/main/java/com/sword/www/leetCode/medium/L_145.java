package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月15日 08:45
 */
public class L_145 {

    /**
     * TODO 想不通
     *
     * @param root
     * @author linmeng
     * @date 2021年1月15日 09:14
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                stack.push(node);
                node = node.left;

            }
        }

        return res;
    }

    /**
     * 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点。
     * @param root
     * @author linmeng
     * @date 2021年1月15日 08:50
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        postOrder(root,res);

        return res;
    }

    private void postOrder(TreeNode node,List<Integer> res){
        if (node==null){
            return;
        }
        postOrder(node.left,res);
        postOrder(node.right,res);
        res.add(node.val);
    }
}
