package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月14日 16:35
 */
public class L_203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = removeElements(head,2);
        System.out.printf("");
    }
    /**
     *
     * 使用哨兵节点作为头结点，
     * 双指针，一个指针指定前节点，另一个指针指定当前节点
     * 当前节点的值等于 val，前一个节点的next等于当前节点的next，当前节点后移一位。
     * 精髓就是这个地方，前一个节点不后移，指针修改删除当前节点。
     * 不等于val的时候，两个节点都后羿
     * @param head
     * @param val
     * @author linmeng
     * @date 2020年12月15日 10:19
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy,node= head;
        while (node!=null){
            if (val==node.val){
                pre.next = node.next;
            }else {
                pre = node;
            }
            node = node.next;
        }

        return dummy.next;
    }
}
