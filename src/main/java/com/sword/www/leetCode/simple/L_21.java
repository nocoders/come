package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author linmeng
 * @version 1.0
 * @date 9/10/2020 上午8:53
 */
public class L_21 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        node.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = mergeTwoLists(node, node3);
        System.out.println();
    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0),tmp1 = l1,tmp2 = l2,step = dummy;
        while (tmp1!=null && tmp2!=null){
            if (tmp1.val<tmp2.val){
                step.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                step.next = tmp2;
                tmp2 = tmp2.next;
            }
            step = step.next;
        }
        while (tmp1!=null){
            step.next = tmp1;
            tmp1 = tmp1.next;
            step = step.next;
        }
        while (tmp2!=null){
            step.next = tmp2;
            tmp2 = tmp2.next;
            step = step.next;
        }

        return dummy.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(),index = res,tmp1 = l1,tmp2 = l2,surplus;
        if (l1==null && l2==null){
            return null;
        }else if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }else {
            while (true){
                if (tmp1.val>tmp2.val){
                    index.next = tmp2;
                    tmp2 = tmp2.next;
                }else {
                    index.next = tmp1;
                    tmp1 = tmp1.next;
                }
                index = index.next;
                if (tmp1 ==null){
                    surplus = tmp2;
                    break;
                }
                if (tmp2 == null){
                    surplus = tmp1;
                    break;
                }
            }
            while (surplus!=null){
                index.next = surplus;
                surplus=surplus.next;
                index = index.next;
            }
            return res.next;
        }

    }
}
