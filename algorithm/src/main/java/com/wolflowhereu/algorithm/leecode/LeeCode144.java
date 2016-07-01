package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-6-30.
 */
public class LeeCode144 {
    private List<Integer> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/binary-tree-preorder-traversal/
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return result;
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }
}
