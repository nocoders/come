package com.sword.www.leetCode.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *   @author linmeng
 * @version 1.0
 * @date 2020年11月30日 09:33
 */
public class L_155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.getMin();
        System.out.println();
    }
    public static class MinStack{

        Deque<String> stack;
        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new LinkedList<>();
        }

        public void push(int x) {
            String poll = stack.peek();
            if (poll!=null){
                String[] array = poll.split(",");
                int minValue = Integer.parseInt(array[1]);
                stack.push(x+","+(Math.min(x, minValue)));
                return;
            }
            stack.push(x+","+x);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return Integer.parseInt(stack.peek().split(",")[0]);
        }

        public int getMin() {
            return Integer.parseInt(stack.peek().split(",")[1]);
        }
    }

}
