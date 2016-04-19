package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode102 {

    public List<List<Integer>> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return result;
    }

    public void levelOrder(TreeNode root, int index) {
        if (root == null) return;
        if (result.size() <= index) {
            List<Integer> level = new ArrayList<>();
            result.add(level);
        }
        result.get(index).add(root.val);
        levelOrder(root.left, index + 1);
        levelOrder(root.right, index + 1);
    }
}
