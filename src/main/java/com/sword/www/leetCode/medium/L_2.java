package com.sword.www.leetCode.medium;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author linmeng
 * @version 1.0
 * @date 2020年12月17日 15:58
 */
public class L_2 {
    /**
     *
     *
     * @param l1
     * @param l2
     * @author linmeng
     * @date 2020年12月17日 16:58
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tmp1 = l1,tmp2 = l2,dummy = head;
        int carry =0,sum;
        while (tmp1!=null || tmp2!=null){
            sum = (tmp1==null?0:tmp1.val) + (tmp2==null?0:tmp2.val)+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;

            tmp1 = tmp1==null? null :tmp1.next;
            tmp2 = tmp2==null? null :tmp2.next;
        }
        if (carry>0){
            dummy.next=new ListNode(carry);
        }

        return head.next;
    }
    /**
     * 两个月前的抄的方法
     * @param l1
     * @param l2
     * @author linmeng
     * @date 2020年12月17日 16:56
     * @return com.sword.www.leetCode.bean.ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1,q = l2,cur = head;
        int carry = 0;
        while(p != null || q != null){
            int x = (p==null)?0:p.val;
            int y = (q==null)?0:q.val;
            int sum = carry+x+y;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur= cur.next;
            if (p != null){
                p = p.next;
            }
            if (q!=null){
                q = q.next;
            }
        }
        if (carry>0){
            cur.next = new ListNode(carry);
        }

        return head.next;
    }
}
