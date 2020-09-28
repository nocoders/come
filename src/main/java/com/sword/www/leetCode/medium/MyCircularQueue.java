package com.sword.www.leetCode.medium;

/**
 *设置循环队列
 *     循环队列
 *Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 * @author linmeng
 * @version 1.0
 * @date 2020/7/23 15:09
 */

class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.Rear();
        circularQueue.isFull();
        circularQueue.deQueue();
        circularQueue.enQueue(4);
        circularQueue.Rear();

    }

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {

        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
        this.capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == this.capacity){
            return false;
        }

        this.queue[(this.headIndex+this.count)%this.capacity] = value;
        this.count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0){
            return false;
        }

        this.headIndex = (++this.headIndex)%this.capacity;
        this.count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.count <= 0){
            return -1;
        }

        return this.queue[this.headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0){
            return -1;
        }

        return this.queue[(this.headIndex+this.count-1)%capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.count == this.capacity;
    }
}