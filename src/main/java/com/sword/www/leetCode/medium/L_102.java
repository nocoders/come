package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println();
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
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
        ArrayList<TreeNode> nextParam = new ArrayList<>();
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
