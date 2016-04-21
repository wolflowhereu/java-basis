package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode first = null, current = null;

        while (root != null) {
            if (root.left != null) {
                if (current == null) {
                    current = root.left;
                    first = current;
                } else {
                    current.next = root.left;
                    current = current.next;
                }
            }

            if (root.right != null) {
                if (current == null) {
                    current = root.right;
                    first = current;
                } else {
                    current.next = root.right;
                    current = current.next;
                }
            }
            root = root.next;
        }
        connect(first);
    }


}
