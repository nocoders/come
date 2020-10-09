package com.sword.www.leetCode.simple;

import com.sword.www.leetCode.bean.ListNode;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author linmeng
 * @version 1.0
 * @date 9/10/2020 下午2:06
 */
public class L_234 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        L_234 l_234 = new L_234();
        boolean palindrome = l_234.isPalindrome(node);
        System.out.printf("");
    }
    public  boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        ListNode mid = generateMidNode(head);
        ListNode last = reverseNode(mid);
        while (last.next!=null){
            if (head.val!=last.val){
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    ListNode generateMidNode(ListNode head){
        ListNode mid = head,last = head;
        while (last.next!=null && last.next.next!=null){
            mid = mid.next;
            last = last.next.next;
        }
        return mid;
    }
    ListNode reverseNode(ListNode mid){

        ListNode pre = null,cur = mid;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
