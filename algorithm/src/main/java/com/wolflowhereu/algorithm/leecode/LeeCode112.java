package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode112 {

    /**
     * https://leetcode.com/problems/path-sum/
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        if (root.left==null && root.right==null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
