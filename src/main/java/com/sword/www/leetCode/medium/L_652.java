package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * 示例 1：
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点
 * @author linmeng
 * @version 1.0
 * @date 2021年1月6日 10:29
 */
public class L_652 {

    public static void main(String[] args) {
        Integer[] a = {2,1,11,11,null,1};
        TreeNode treeNode = TreeNode.arrayTransferToNode(a,0);
        L_652 l_652 = new L_652();
        List<TreeNode> duplicateSubtrees = l_652.findDuplicateSubtrees(treeNode);
        System.out.println();
    }

    private List<TreeNode> res;
    private Map<String,Integer>map;

    /**
     * 使用深度优先搜索，递归将每个节点节点值以及子节点的值按照节点左节点，右节点的顺序保存为字符串，
     * 保存的同时判断map中该字符串出现的次数是否等于2，等于2就添加到返回集合中
     * @param root
     * @author linmeng
     * @date 2021年1月8日 10:52
     * @return java.util.List<com.sword.www.leetCode.bean.TreeNode>
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        collect(root);
        return res;
    }

    private String collect(TreeNode node) {
        if (node==null){
            return "#";
        }
        String str = node.val +","+ collect(node.left) + "," + collect(node.right);
        map.put(str,map.getOrDefault(str,0)+1);
        if (map.get(str)==2){
            res.add(node);
        }

        return str;
    }
}
