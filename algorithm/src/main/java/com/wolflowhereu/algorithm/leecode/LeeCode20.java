package com.wolflowhereu.algorithm.leecode;

import java.util.Stack;

/**
 * @author jx09.
 * @Date 16-3-28.
 * @Discreption
 */
public class LeeCode20 {
    /**
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) stack.push(s.charAt(i));
            else {
                Character character = stack.peek();
                switch (character + "" + s.charAt(i)) {
                    case "()": {
                        stack.pop();
                        break;
                    }
                    case "[]": {
                        stack.pop();
                        break;
                    }
                    case "{}": {
                        stack.pop();
                        break;
                    }
                    default:
                        stack.push(s.charAt(i));
                }
            }
        }
        if (stack.size() <= 0) return true;
        return false;
    }

}
