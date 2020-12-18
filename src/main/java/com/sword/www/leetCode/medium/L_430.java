package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.Node;

/**
 * TODO 想不通
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月17日 18:17
 */
public class L_430 {
    public static void main(String[] args) {
        Node head0 = new Node(0,null,null,null);
        Node node1 = new Node(1,head0,null,null);
        Node node2 = new Node(2,node1,null,null);
        Node node3 = new Node(3,node2,null,null);
        Node node4 = new Node(4,node3,null,null);
        Node node5 = new Node(5,node4,null,null);
        Node node6 = new Node(6,node5,null,null);

        Node node7 = new Node(7,null,null,null);
        Node node8 = new Node(8,node7,null,null);
        Node node9 = new Node(9,node8,null,null);
        Node node10 = new Node(10,node9,null,null);

        Node node11 = new Node(11,null,null,null);
        Node node12 = new Node(12,node11,null,null);

        head0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node11.next = node12;

        node3.child = node7;
        node8.child = node11;

        System.out.println();
        Node flatten = flatten(head0);
        System.out.println();
    }
    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        // pseudo head to ensure the `prev` pointer is never none
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
    /* return the tail of the flatten list */
    public static Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        // the curr.next would be tempered in the recursive function
        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }
}
