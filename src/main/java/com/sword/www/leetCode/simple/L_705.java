package com.sword.www.leetCode.simple;

import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 * 具体地说，你的设计应该包含以下的功能
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * 示例:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 * 注意：
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 * @author linmeng
 * @version 1.0
 * @date 2020年12月18日 10:57
 */
public class L_705 {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        boolean contains = hashSet.contains(1);
        boolean contains1 = hashSet.contains(3);
        hashSet.add(2);
        boolean contains2 = hashSet.contains(2);
        hashSet.remove(2);
        boolean contains3 = hashSet.contains(2);
        System.out.println();
    }
    static class MyHashSet {
        private Bucket[] bucketArray;
        private int keyRange;

        /** Initialize your data structure here. */
        public MyHashSet() {
            this.keyRange = 769;
            this.bucketArray = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; i++) {
                bucketArray[i] = new Bucket();
            }
        }
        protected int _hash(int val){
            return val%this.keyRange;
        }
        public void add(int key) {
            this.bucketArray[_hash(key)].insert(key);
        }

        public void remove(int key) {
            this.bucketArray[_hash(key)].delete(key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int keyHash = _hash(key);
            return this.bucketArray[keyHash].contains(key);
        }
    }


    static class Bucket {
        private LinkedList<Integer> container;
        public Bucket(){
            this.container = new LinkedList<>();
        }
        public void insert(int val){
            if (this.container.indexOf(val)!=-1){
                return;
            }
            this.container.addFirst(val);
        }
        public void delete(int val){
            int index = this.container.indexOf(val);
            if (index!=-1){
                this.container.remove(index);
            }
        }
        public boolean contains(int val){
            return this.container.indexOf(val)!=-1;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
