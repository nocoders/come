package com.sword.www.leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
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
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 提示：
 * 树中节点的数量少于 4096
 * -1000 <= node.val <= 1000
 * @author linmeng
 * @version 1.0
 * @date 2021年2月2日 09:07
 */
public class L_116 {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Node node = new Node();
        Node node1 = node.arrayTransferToNode(nodes, 0);
        Node connect = connectFx(node1);
        System.out.println();
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node arrayTransferToNode(Integer[] arrays, int index) {
            Node tn = null;
            if (index < arrays.length) {
                Integer value = arrays[index];
                if (value == null) {
                    return null;
                }
                tn = new Node(value);
                tn.left = arrayTransferToNode(arrays, 2 * index + 1);
                tn.right = arrayTransferToNode(arrays, 2 * index + 2);

                return tn;
            }

            return tn;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            while (size > 0) {
                Node node = queue.poll();
                if (size - 1 > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            size = queue.size();
        }
        return root;
    }

    /**
     * 将每行的节点使用next指针连接
     * 使用队列保存每行元素，然后进行连接
     *
     * @param root
     * @return com.sword.www.leetCode.medium.L_116.Node
     * @author linmeng
     * @date 2021年4月1日 22:05
     */
    public static Node connectFx(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n != null) {
                    if (size - i > 1) {
                        n.next = queue.peek();
                    }
                    if (n.left != null) {
                        queue.offer(n.left);
                        queue.offer(n.right);

                    }
                }
            }
            size = queue.size();
        }
        return root;
    }
    /**
     * 空间复杂度O(1)解法：
     *      遍历本层节点，将下层节点使用next连接
     *      node.left.next = node.right
     *      node.right.next = node.next.left
     *      node=node.next
     * @param root
     * @author linmeng
     * @date 2021年4月1日 22:31
     * @return com.sword.www.leetCode.medium.L_116.Node
     */
    public static Node connectFx2(Node root) {
        Node leftMost = root;
        // 在外成判断是否有下一层，因为内层循环是给下一层设置指针的
        while (leftMost.left!=null){
            Node head = leftMost;
            while (head!=null){
                head.left.next=head.right;
                if (head.next!=null){
                    head.right.next=head.next.left;
                }
                head=head.next;
            }
            leftMost=leftMost.left;
        }
        return root;
    }
}
