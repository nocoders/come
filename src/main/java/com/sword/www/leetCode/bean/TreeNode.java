package com.sword.www.leetCode.bean;

/**
 * TODO
 *
 * @author linmeng
 * @version 1.0
 * @date 10/10/2020 上午9:00
 */
public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(Integer x) { val = x; }

    public static TreeNode arrayTransferToNode(Integer[] arrays,int index){
        TreeNode tn = null;
        if (index < arrays.length){
            Integer value = arrays[index];
            if (value == null){
                return null;
            }
            tn = new TreeNode(value);
            tn.left = arrayTransferToNode(arrays,2*index+1);
            tn.right = arrayTransferToNode(arrays,2*index+2);

            return tn;
        }

        return tn;
    }
}
