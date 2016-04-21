package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode124 {
    int result = Integer.MIN_VALUE;

    /**
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        function(root);
        return result;
    }

    private int function(TreeNode root) {
        if (root == null) return 0;
        int leftValue = function(root.left);
        int rightValue = function(root.right);

        int value = root.val;
        if (leftValue > 0) {
            value += leftValue;
        }
        if (rightValue > 0) {
            value += rightValue;
        }
        result = Math.max(value, result);
        return Math.max(Math.max(Math.max(leftValue, rightValue), 0) + root.val, 0);
    }
}
