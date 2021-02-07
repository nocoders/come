package com.sword.www.leetCode.hard;

import com.sword.www.leetCode.bean.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 提示：
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * @author linmeng
 * @version 1.0
 * @date 2021年2月7日 09:02
 */
public class L_297 {
    public static void main(String[] args) {
        Integer[] arrs = {1, 2, 3, null, null, 4, 5};
        TreeNode node = TreeNode.arrayTransferToNode(arrs, 0);
        L_297 l_297 = new L_297();
        String serialize = l_297.serialize(node);
        TreeNode deserialize = l_297.deserialize(serialize);
        System.out.println();
    }

    private String str ="";
    private TreeNode deserNode;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            str+="none,";
        }else {
            str+=root.val+",";
            serialize(root.left);
            serialize(root.right);
        }
        return str;
    }
    /**
     * 反序列化同序列化顺序相同，对序列化进行解析
     * @param data
     * @author linmeng
     * @date 2021年2月7日 16:31
     * @return com.sword.www.leetCode.bean.TreeNode
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        return rdeserialize(new LinkedList<>(Arrays.asList(dataArray)));
    }

    private TreeNode rdeserialize(List<String>dataList){
        String val = dataList.get(0);
        if ("none".equals(val)){
            dataList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        dataList.remove(0);
        node.left=rdeserialize(dataList);
        node.right=rdeserialize(dataList);

        return node;
    }
}
