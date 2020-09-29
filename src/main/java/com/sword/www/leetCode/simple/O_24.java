package com.sword.www.leetCode.simple;


import com.sword.www.leetCode.bean.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author linmeng
 * @version 1.0
 * @date 29/9/2020 上午9:56
 */
public class O_24 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null,cur = head;

        while (cur !=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseList(head);
        System.out.printf("");
    }
}
