package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月15日 10:26
 */
public class L_328 {

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
        ListNode node = oddEvenList(head);
        System.out.printf("");
    }
    /**
     * 一个代表奇数节点指针，一个代表偶数节点指针.
     * 将奇数的跟偶数的分别用上面的指针进行next替换
     * 最后奇数最后节点同偶数首节点连接。
     * 偶数首节点开始时已经保存
     * @param head
     * @author linmeng
     * @date 2020年12月16日 13:55
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode odd = head,even = head.next,evenhead = even;
        while (even != null && even.next!=null){
            odd.next=even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;

        return head;
    }
}
