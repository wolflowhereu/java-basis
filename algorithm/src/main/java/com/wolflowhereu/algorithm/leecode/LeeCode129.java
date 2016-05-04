package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fan on 16-5-4.
 */
public class LeeCode129 {


    /**
     * https://leetcode.com/problems/sum-root-to-leaf-numbers/
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int parentValue) {
        if (root==null) return 0;
        parentValue = parentValue * 10 + root.val;
        if (root.left == null && root.right == null) return parentValue;
        return sumNumbers(root.left, parentValue) + sumNumbers(root.right, parentValue);
    }
}
