package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author linmeng
 * @version 1.0
 * @date 2021年1月20日 10:39
 */
public class L_106 {
    int post_idx;
    int[] inorder,postorder;
    Map<Integer, Integer> idx_map = new HashMap<>();


    public TreeNode helper(int in_left, int in_right) {
        if (in_left>in_right){
            return null;
        }
        int val = postorder[post_idx];
        TreeNode node = new TreeNode(val);
        Integer index = idx_map.get(val);
        post_idx--;
        // 需要先构建右子树，再构建左子树，具体原因应该是后续遍历是左右中，解析需要反过来
        node.right = helper(index+1,in_right);
        node.left = helper(in_left,index-1);

        return node;
    }
    /**
     * 中序左中右，后序左右中
     *      把中序遍历的数组放到map里面，后序遍历的最后一个元素是根节点
     *      根据根节点再中序遍历中所在的位置区分出该子节点下面的左右子树
     *      对下面的左右子树进行递归求树的整体结构
     * @param inorder
     * @param postorder
     * @author linmeng
     * @date 2021年1月20日 10:40
     * @return com.sword.www.leetCode.bean.TreeNode
     */
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            post_idx = postorder.length-1;
            this.inorder = inorder;
            this.postorder = postorder;
            int idx = 0;
            for (Integer val : inorder) {
                idx_map.put(val, idx++);
            }

            return helper(0, inorder.length-1);
        }
}
