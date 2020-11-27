package com.sword.www.leetCode.medium;

/**
 * 622. 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
 * 但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * 示例：
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * 提示：
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 * @author linmeng
 * @version 1.0
 * @date 2020年11月23日 16:05
 */
public class L_622 {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        boolean b = circularQueue.enQueue(1);
        boolean b1 = circularQueue.enQueue(2);
        boolean b2 = circularQueue.enQueue(3);
        boolean b3 = circularQueue.enQueue(4);
        int rear = circularQueue.Rear();
        boolean full = circularQueue.isFull();
        boolean b4 = circularQueue.deQueue();
        boolean b5 = circularQueue.enQueue(4);
        int rear1 = circularQueue.Rear();
        System.out.println();
    }
   static class MyCircularQueue{
       int [] nums;
       int size;
       int capacity;
       int first;
       int last;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.nums = new int[k];
            this.size = 0;
            this.capacity = k;
            this.first = -1;
            this.last = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
            first = ++first % capacity;
            nums[first] = value;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            last = ++last%capacity;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return nums[first];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()){
                return -1;
            }
            return nums[last];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == capacity;
        }
    }
}
