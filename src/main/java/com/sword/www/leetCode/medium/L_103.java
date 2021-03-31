package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author linmeng
 * @version 1.0
 * @date 2021年3月31日 20:12
 */
public class L_103 {

    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode node = TreeNode.arrayTransferToNode(nodes, 0);
        List<List<Integer>> lists = zigzagLevelOrder(node);
        System.out.println(lists.toString());
    }

    /**
     * S形走位保存节点的值
     * 广度优先搜索，使用集合保存每行的节点
     * 定义布尔值，是否反转
     * 遍历该行节点，使用双端队列保存节点的值，若布尔值为正，则保存到头部表示反转，若布尔值为负，保存到尾部，不反转
     * 定义deque保存当前节点下的左右节点
     * 将deque赋值给当前节点
     *
     * @param root
     * @author linmeng
     * @date 2021年3月31日 21:48
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean isReverse=false;
        // 保存每行的节点
        List<TreeNode> nodeList = new ArrayList<>();
        // 存储每行的val
        Deque<Integer> deque = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()){
            List<TreeNode> tmpList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (node!=null){
                    if (isReverse){
                        deque.offerFirst(node.val);
                    }else {
                        deque.offerLast(node.val);
                    }
                    tmpList.add(node.left);
                    tmpList.add(node.right);
                }
            }
            isReverse= !isReverse;
            if (!deque.isEmpty()){
                res.add(new LinkedList<>(deque));
            }
            deque=new LinkedList<>();
            nodeList=tmpList;
        }

        return res;
    }
}
