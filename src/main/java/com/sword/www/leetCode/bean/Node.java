package com.sword.www.leetCode.bean;

/**
 * TODO
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月17日 18:17
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
