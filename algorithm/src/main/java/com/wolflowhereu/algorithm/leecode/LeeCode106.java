package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode106 {


    int p = 0, i = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, Integer.MIN_VALUE - 111, null);
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int preValue, TreeNode left) {

        if (p >= postorder.length || i >= inorder.length) return left;
        if (postorder[p] == preValue) return left;

        TreeNode treeNode = new TreeNode(inorder[i]);
        treeNode.left = left;

        i++;
        treeNode.right = buildTree(inorder, postorder, treeNode.val, null);
        p++;

        return buildTree(inorder, postorder, preValue, treeNode);
    }


    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{1,2}, new int[]{2,1});
    }
}
