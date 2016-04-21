package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode114 {

    /**
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenRight(root);
    }

    private TreeNode flattenRight(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        if (root.left == null) return flattenRight(root.right);
        TreeNode node = flattenRight(root.left);
        node.right = root.right;
        root.right = root.left;
        root.left = null;
        return flattenRight(root.right);
    }


}
