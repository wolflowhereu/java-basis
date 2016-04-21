package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanhongbin on 2016/4/20.
 */
public class LeeCode113 {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/path-sum-ii/
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        hasPathSum(root, sum);

        for (List<Integer> list : result) {
            for (int i = 0; i < list.size() / 2; i++) {
                int tmp = list.get(i);
                list.set(i, list.get(list.size() - 1 - i));
                list.set(list.size() - 1 - i, tmp);
            }
        }

        return result;
    }

    private int hasPathSum(TreeNode root, int sum) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) {
            if (root.val != sum) return -1;
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
            return result.size() - 1;
        }
        int startIndex = result.size();
        int endIndex = Math.max(hasPathSum(root.left, sum - root.val), hasPathSum(root.right, sum - root.val));
        while (startIndex <= endIndex) {
            result.get(startIndex).add(root.val);
            startIndex++;
        }
        return endIndex;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);

        pathSum(root, 15);
    }
}
