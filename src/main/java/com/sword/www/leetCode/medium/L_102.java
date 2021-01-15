package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author linmeng
 * @version 1.0
 * @date 19/10/2020 上午9:14
 */
public class L_102 {

    public static void main(String[] args) {
        Integer[] a = {3,9,20,null,null,15,7};
        TreeNode treeNode = TreeNode.arrayTransferToNode(a,0);
        List<List<Integer>> lists = levelOrder2(treeNode);
        System.out.println();
    }
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        while (!queue.isEmpty()){
            ArrayList<Integer> levelInfos = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelInfos.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(levelInfos);
        }

        return res;
    }
    /**
     * 每一层的数据的值保存到一个集合里面，然后保存下一层的节点，递归执行这一流程
     * @param root
     * @author linmeng
     * @date 2021年1月15日 09:55
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        // 将根节点下面的左右节点放入集合中
        res.add(Arrays.asList(root.val));
        ArrayList<TreeNode> param = new ArrayList<>();
        if (root.left!=null){
            param.add(root.left);
        }
        if (root.right!=null){
            param.add(root.right);
        }
        addVal(param,res);

        return res;
    }

    public static void addVal(List<TreeNode> param,List<List<Integer>> res){
        if (param == null || param.size()==0){
            return;
        }
        // 用于递归保存下一层的节点
        ArrayList<TreeNode> nextParam = new ArrayList<>();
        // 保存当前层的节点的值
        ArrayList<Integer> currentVal = new ArrayList<>();
        for (TreeNode node : param) {
           currentVal.add(node.val);
           if (node.left!=null){
               nextParam.add(node.left);
           }
           if (node.right!=null){
               nextParam.add(node.right);
           }
        }
        res.add(currentVal);
        addVal(nextParam,res);
    }
}
