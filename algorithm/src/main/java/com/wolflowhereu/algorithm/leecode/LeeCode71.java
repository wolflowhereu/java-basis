package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * @author jx09.
 * @Date 16-3-31.
 * @Discreption
 */
public class LeeCode71 {

    /**
     * https://leetcode.com/problems/simplify-path/
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        String[] stack = new String[paths.length];
        int stackSize = 0;

        for (String s : paths) {
            switch (s){
                case "": break;
                case ".":break;
                case "..":{
                    if (stackSize>0) stackSize--;
                    break;
                }
                default:{
                    stack[stackSize++] = s;
                }
            }
        }
        if (stackSize<=0) return "/";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackSize; i++) {
            sb.append("/").append(stack[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/home//..//..///..///./"));
    }
}
