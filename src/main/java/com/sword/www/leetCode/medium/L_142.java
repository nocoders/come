package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月13日 09:52
 */
public class L_142 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node1;
        ListNode node4 = detectCycle(node);

        System.out.println();
    }
    /**
     * 同上一个不一样，这个slow跟fast不能错位，错位的话就找不到最后那个循环点
     * @param head
     * @author linmeng
     * @date 2020年12月13日 10:34
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public static ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head,fast = head,res = head;
        while (fast!=null){
            slow=slow.next;
            if (fast.next == null){
                return null;
            }else {
                fast = fast.next.next;
            }
            if (slow==fast){
                while (slow!=res){
                    slow=slow.next;
                    res=res.next;
                }
                return res;
            }
        }

        return null;
    }
}
