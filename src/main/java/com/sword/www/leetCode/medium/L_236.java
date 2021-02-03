package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中
 * 图：binarytree.png
 * @author linmeng
 * @version 1.0
 * @date 2021年2月3日 15:21
 */
public class L_236 {
    public static void main(String[] args) {
        Integer [] a = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode node = TreeNode.arrayTransferToNode(a, 0);
        L_236 l_236 = new L_236();
        TreeNode node1 = l_236.lowestCommonAncestor(node, new TreeNode(5), new TreeNode(1));
        System.out.println();
    }

    private TreeNode res;
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * dfs遍历，
     * @param root 二叉树
     * @param p 节点，用于二叉树中查询最近公共祖先
     * @param q 节点，用于二叉树中查询最近公共祖先
     * @author linmeng
     * @date 2021年2月3日 15:22
     * @return com.sword.www.leetCode.bean.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return false;
        }
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);
        // 判断当前节点是否是否左右节点是pq，或者当前节点中有一个值满足切子节点中满足另外一个值
        if ((lson&&rson) || ((root.val==p.val || root.val==q.val)&&(lson||rson))){
            res = root;
            return true;
        }
        // 这个地方只要有一个元素满足条件就返回true，但是没有添加res
        return lson||rson||root.val==p.val || root.val==q.val;
    }
}
