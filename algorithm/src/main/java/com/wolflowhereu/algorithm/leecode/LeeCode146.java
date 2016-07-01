package com.wolflowhereu.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fan on 16-6-30.
 */
public class LeeCode146 {

    private int size = 0, capacity = 0;
    private DoublyListNode head = new DoublyListNode(0,0), tail = new DoublyListNode(0,0);
    private Map<Integer, DoublyListNode> map = new HashMap<>();

    /**
     * https://leetcode.com/problems/lru-cache/
     *
     * @param capacity
     */
    public LeeCode146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.back = head;
    }

    public int get(int key) {
        DoublyListNode result = map.get(key);
        if (result != null) {
            deleteNode(result);
            addToHead(result);
            return result.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        DoublyListNode result = map.get(key);

        if (result == null) {
            result = new DoublyListNode(key, value);
            map.put(key, result);
        } else deleteNode(result);

        result.val = value;
        addToHead(result);

        if (size > capacity) {
            map.remove(pop());
        }
    }

    private void addToHead(DoublyListNode node) {
        size++;
        node.next = head.next;
        node.next.back = node;
        node.back = head;
        head.next = node;
    }

    private void deleteNode(DoublyListNode node) {
        size--;
        node.back.next = node.next;
        node.next.back = node.back;
    }


    private int pop() {
        int key = tail.back.key;
        deleteNode(tail.back);
        return key;
    }

    class DoublyListNode {
        public int key;
        public int val;
        DoublyListNode next;
        DoublyListNode back;

        DoublyListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeeCode146 leeCode146 = new LeeCode146(1);
        leeCode146.set(2, 1);
        leeCode146.set(3, 1);
        System.out.println(leeCode146.get(2));
    }
}
