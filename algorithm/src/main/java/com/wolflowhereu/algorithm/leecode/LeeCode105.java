package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode105 {

    int p = 0, i = 0;


    /**
     * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE - 100);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder, int preValue) {
        if (p >= preorder.length || i >= inorder.length) return null;
        if (preValue == inorder[i]) return null;

        TreeNode treeNode = new TreeNode(preorder[p]);
        p++;
        treeNode.left = buildTree(preorder, inorder, treeNode.val);
        i++;
        treeNode.right = buildTree(preorder, inorder, preValue);

        return treeNode;
    }





}
