package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-4-16.
 */
public class LeeCode94 {
    List<Integer> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal/
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
