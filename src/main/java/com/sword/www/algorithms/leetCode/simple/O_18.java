package com.sword.www.algorithms.leetCode.simple;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author linmeng
 * @version 1.0
 * @date 20/8/2020 上午10:04
 */
public class O_18 {

    /**
     * 链表
     * @author linmeng
     * @date 20/8/2020 上午10:06
     * @return
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    /**
     * 根据链表头，要删除的值 遍历链表，进行 删除
     * @param head
     * @param val
     * @author linmeng
     * @date 20/8/2020 上午10:07
     * @return com.sword.www.algorithms.leetCode.simple.O_18.ListNode
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode res = null,tmp = head;
        while (tmp != null){
            if (tmp.val == val){
                if (res == null){
                    return tmp.next;
                }
                res.next = tmp.next;
                return head;
            }else {
                res = tmp;
                tmp = tmp.next;
            }
        }
        return null;
    }
}
