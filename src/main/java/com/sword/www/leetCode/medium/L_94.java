package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author linmeng
 * @version 1.0
 * @date 2021年1月13日 15:27
 */
public class L_94 {

    /**
     * 中序遍历遍历顺序是左中右，
     * 根节点开始，把根节点后面的所有的左节点放到栈里
     * 然后出栈，出栈时把值放入返回结果中，前序遍历是入栈是把值放入返回结果中
     *
     * @param root
     * @author linmeng
     * @date 2021年1月14日 16:15
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode>stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node!=null ){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }
    /**
     * 中序遍历：树左中右这种方式进行遍历
     *
     * @param root
     * @author linmeng
     * @date 2021年1月13日 16:35
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(res,root);

        return res;
    }

    private void  inOrder(List<Integer>res,TreeNode node){
        if (node == null){
            return;
        }
        inOrder(res,node.left);
        res.add(node.val);
        inOrder(res, node.right);
    }
}
