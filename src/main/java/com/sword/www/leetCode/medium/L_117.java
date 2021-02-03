package com.sword.www.leetCode.medium;

/**
 * TODO 不会，看不懂
 *
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
            last = null;
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
}
