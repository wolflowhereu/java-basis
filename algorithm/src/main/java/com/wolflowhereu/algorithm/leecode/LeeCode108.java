package com.wolflowhereu.algorithm.leecode;

/**
 * Created by fanhongbin on 2016/4/19.
 */
public class LeeCode108 {

    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex>endIndex) return null;
        int mid = (startIndex + endIndex) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, startIndex, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, endIndex);
        return treeNode;
    }
}
