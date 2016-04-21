package com.wolflowhereu.algorithm.leecode;

import java.util.List;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode107 {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LeeCode102 leeCode102 = new LeeCode102();
        List<List<Integer>> result = leeCode102.levelOrder(root);

        for (int i = 0; i < result.size() / 2; i++) {
            List<Integer> tmp = result.get(i);
            result.set(i, result.get(result.size() - i - 1));
            result.set(result.size() - i - 1, tmp);
        }

        return result;
    }
}
