package com.sword.www.leetCode.medium;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 提示：
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * @author linmeng
 * @version 1.0
 * @date 2021年2月2日 11:08
 */
public class L_117 {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,3,4,5,6,7};
        Node node = new Node();
        Node node1 = node.arrayTransferToNode(nodes, 0);
        Node connect = connect(node1);
        System.out.println();
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            this.val = _val;
            this.left = _left;
            this.right = _right;
            this.next = _next;
        }
        public Node arrayTransferToNode(Integer[] arrays, int index){
            Node tn = null;
            if (index < arrays.length){
                Integer value = arrays[index];
                if (value == null){
                    return null;
                }
                tn = new Node(value);
                tn.left = arrayTransferToNode(arrays,2*index+1);
                tn.right = arrayTransferToNode(arrays,2*index+2);

                return tn;
            }

            return tn;
        }
    }
    static Node last = null, nextStart = null;

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            // 保存上一个节点
            last = null;
            // 用于当前层遍历完成后，保存下一行元素的起点，复制给start
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }


    public static void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {// node.left 进入时把nextStart赋值为该节点
            nextStart = p;
        }
        last = p;// 把p节点赋值给last
    }

    /**
     * 复习：从根节点开始，每层都是已经有next指针的。
     *      定义三个变量：start：每层的开始节点，用于遍历，nextStart：下一层的开始节点，
     * 遍历start层时将start的第一个节点的不为空的节点赋值。last：保存该层上一个节点。
     *
     * @param root
     * @author linmeng
     * @date 2021年4月7日 21:17
     * @return com.sword.www.leetCode.medium.L_117.Node
     */
    public static Node connectFx(Node root) {
        if (root==null){
            return null;
        }
        Node start=root;
        while (start!=null){
            last=null;
            nextStart=null;
            for(Node p=start;p!=null;p=p.next){
                if (p.left!=null){
                    handleFx(p);
                }
                if (p.right!=null){
                    handleFx(p);
                }
            }
            start=nextStart;
        }
        return root;
    }

    private static void handleFx(Node p) {
        if (nextStart==null){
            nextStart=p;
        }
        if (last!=null){
            last.next=p;
        }
        last=p;
    }
}
