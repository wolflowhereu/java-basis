package com.wolflowhereu.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/18.
 */
public class LeeCode103 {

    private List<List<Integer>> result = new ArrayList<>();


    /**
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LeeCode102 leeCode102 = new LeeCode102();
        leeCode102.levelOrder(root);

        result = leeCode102.result;
        for (int i = 1; i < result.size(); i+=2) {
            reversal(result.get(i));
        }
        return result;
    }

    private void reversal(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int tmp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, tmp);
        }
    }

}
