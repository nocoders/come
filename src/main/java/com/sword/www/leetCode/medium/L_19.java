package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.ListNode;

/**
 * L_19 删除链表的倒数第N个节点
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
    /** 0 1 2 3 4 5
     * 指定一个空节点，
     * 指定两个指针，都等于空节点。
     * 让第二个指针先走n+1步，然后两个指针同时往后走,这样当第二个指针为空的时候，第一个指针正好在倒数n+1个节点上
     * 这个时候只要把next设置成next.next就可以了
     *
     * @param head
     * @param n
     * @author linmeng
     * @date 2020年12月14日 15:56
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode first = dummy,second = dummy;
        for (int i = 1; i <= n+1; i++) {
            second = second.next;
        }
        while (second!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}



