package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by fan on 16-7-1.
 */
public class LeeCode155 {
    private Stack<Integer> stack = new Stack<>();
    private List<Integer> sortList = new ArrayList<>();
    private boolean sorted = true;

    /**
     * https://leetcode.com/problems/min-stack/
     * @param x
     */
    public void push(int x) {
        sortList.add(x);
        stack.push(x);
        sorted = false;
    }

    public void pop() {
        if (!stack.isEmpty()) sortList.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (sortList.size()>0) {
            if (!sorted) {
                Collections.sort(sortList);
                sorted = true;
            }
            return sortList.get(0);
        }
        return -1;
    }
}
