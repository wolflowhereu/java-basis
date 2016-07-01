package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-6-30.
 */
public class LeeCode145 {
    private List<Integer> result = new ArrayList<>();


    /**
     * https://leetcode.com/problems/binary-tree-postorder-traversal/
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null) return result;
        int val = root.val;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(val);
        return result;
    }
}
