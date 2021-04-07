package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * @author linmeng
 * @version 1.0
 * @date 2021年4月7日 21:29
 */
public class L_230 {

    /**
     * 查询第k小的元素
     *      二叉树中序遍历是从小到大进行排列的
     *   根据中序遍历获取到最小的元素，给定一个变量等于零，中序遍历一次就加一，等于k时就结束
     *   递归解决问题
     * @param root
     * @param k
     * @author linmeng
     * @date 2021年4月7日 21:34
     * @return int
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root==null){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        bl(list,root,k);
        return list.size()>=k?list.get(k-1):-1;
    }

    private void bl(ArrayList<Integer> list, TreeNode node,int k) {
        if (node==null){
            return;
        }
        bl(list,node.left,k);
        if (list.size()==k){
            return;
        }
        list.add(node.val);
        bl(list,node.right,k);
    }

    /**
     * 迭代解决问题
     * @param root
     * @param k
     * @author linmeng
     * @date 2021年4月7日 21:55
     * @return int
     */
    public int kthSmallestDd(TreeNode root, int k) {
        if (root==null){
            return -1;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node=root;
        while (true){
            while (node!=null){
                stack.add(node);
                node=node.left;
            }
            node = stack.removeLast();
            if (--k==0){
                return node.val;
            }
            node=node.right;
        }
    }
}
