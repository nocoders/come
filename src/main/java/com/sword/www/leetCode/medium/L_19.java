package com.sword.www.leetCode.medium;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author linmeng
 * @version 1.0
 * @date 28/9/2020 上午9:01
 */
public class L_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head,second = head;
        // 这个n+1很精髓，因为下面的while循环是多跑一下，second==null的时候就是已经跑到链表外面去了，正好跟现在这个多跑的一次抵消
        for (int i = 1; i <= n+1; i++) {
            second = second.next;
        }
        while (second!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



