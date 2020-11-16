package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author linmeng
 * @version 1.0
 * @date 10/10/2020 下午4:37
 */
public class L_98 {
    public static void main(String[] args) {
        Integer[] a = {10,5,15,null,null,6,20};
        TreeNode treeNode = TreeNode.arrayTransferToNode(a,0);
        boolean validBST = isValidBST2(treeNode);
        System.out.printf("");
    }
    /**
     * 
     * 这个报错，如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
     * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
     * 我这边写的是当前节点下面子节点左边小于当前节点，应当从根节点开始判断
     * @param null
     * @author linmeng
     * @date 14/10/2020 上午11:19 
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return valid(root,null,null);
    }

    private static boolean valid(TreeNode node, Integer left, Integer right) {
        if (node == null){
            return true;
        }
        Integer val = node.val;
        if (left!=null && val<=left){
            return false;
        }
        if (right!=null && val>=right){
            return false;
        }
        if (!valid(node.right, val, right)) {
            return false;
        }
        if (!valid(node.left,left,val)){
            return false;
        }
        return true;
    }

    public static boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        boolean leftResult = true,rightResult = true;
//        TreeNode leftNode = root.left,rightNode = root.right;
//        if ((leftNode!=null) ){
//            if (leftNode.val >= root.val){
//                    return false;
//            }
//            rightResult =  isValidBST(rightNode);
//        }
//
//        return leftResult && rightResult;
//    }
}
