package com.wolflowhereu.algorithm.leecode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fan on 16-4-16.
 */
public class LeeCode95 {

    /**
     * https://leetcode.com/problems/unique-binary-search-trees-ii/
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n<1) return Collections.emptyList();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftNode : leftTrees){
                for (TreeNode rightNode : rightTrees){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        if (result.size()<=0) result.add(null);
        return result;
    }

}
