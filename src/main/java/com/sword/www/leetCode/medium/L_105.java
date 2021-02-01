package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author linmeng
 * @version 1.0
 * @date 2021年1月29日 10:08
 */
public class L_105 {
   static Map<Integer, Integer> map = new HashMap<>();
    /**
     * 前序与中序遍历构造二叉树：前序遍历中左右，中序遍历左中右
     * 将中序遍历的元素跟角标保存到map里面
     * 开始递归
     * 前序遍历中最左边的元素永远是当前树的根节点，保存map里面的元素用来获取根节点在中序遍历中的角标。
     * 这个角标用来进行判断迭代的结束
     *
     * @param preorder
     * @param inorder
     * @author linmeng
     * @date 2021年1月29日 10:17
     * @return com.sword.www.leetCode.bean.TreeNode
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i],i);
        }
        int preLen = preorder.length,inLen = inorder.length;
        if (preLen!=inLen){
            throw new RuntimeException();
        }

        return buildTree(preorder,0,preLen-1,0,inLen-1);
    }

    private static TreeNode buildTree(int[] preorder, int preLenLeft, int preLenRight, int inLenLeft, int inLenRight) {
        if (preLenLeft>preLenRight || inLenLeft>inLenRight){
            return null;
        }
        int rootVal = preorder[preLenLeft];
        int inIndex = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        int subLen = inIndex-inLenLeft;
        node.left = buildTree(preorder,preLenLeft+1,preLenLeft+subLen,inLenLeft,inIndex-1);
        node.right = buildTree(preorder,preLenLeft+subLen+1,preLenRight,inIndex+1,inLenRight);

        return node;
    }
}
