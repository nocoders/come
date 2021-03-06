package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * 提示：
 * 节点总数 <= 10000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author linmeng
 * @version 1.0
 * @date 10/10/2020 上午9:02
 */
public class O_55 {
    public static void main(String[] args) {
        Integer [] a = {3,9,20,null,null,15,7};
        TreeNode treeNode = TreeNode.arrayTransferToNode(a, 0);
        int i = maxDepth(treeNode);
        System.out.printf("");
    }
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }},tmp=new LinkedList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    tmp.add(node.left);
                }
                if (node.right!=null){
                    tmp.add(node.right);
                }
            }
            res ++;
            queue = tmp;
        }

        return res;
    }
}
