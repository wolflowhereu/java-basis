package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode111 {

    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 1);
    }

    public int minDepth(TreeNode root, int depth) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return depth;
        return Math.min(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1));
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(minDepth(root));
    }
}
