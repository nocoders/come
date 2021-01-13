package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * @author linmeng
 * @version 1.0
 * @date 2021年1月13日 09:12
 */
public class L_144 {

    /**
     * 使用显式栈保存当前需要遍历的节点，先遍历当前节点下的所有的左节点，再遍历所有的右节点
     * @param root
     * @author linmeng
     * @date 2021年1月13日 15:13
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root==null){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node!=null ){
            while (node!=null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right;
        }

        return res;
    }

    /**
     * 前序遍历，遍历当前节点，然后遍历左子树，再遍历右子树，在左右子树中也是同样顺序遍历
     *
     * @param root
     * @author linmeng
     * @date 2021年1月13日 09:34
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(res,root);

        return res;
    }

    private void preorder(List<Integer> res,TreeNode node){
        if (node==null){
            return;
        }
        res.add(node.val);
        preorder(res, node.left);
        preorder(res, node.right);
    }
}
