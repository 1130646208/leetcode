package com.wsx.binaryTree.leetcode_offer27;

import com.wsx.binaryTree.util.*;

/**
 * 求二叉树镜像
 *
 * @author shuangxing.wang
 */

public class leetcode_offer27 {
    public static TreeNode mirrorTree(TreeNode root) {
        return dfs(root);
    }

    public static TreeNode dfs(TreeNode node){
        TreeNode result = null;
        if (node == null){
            return node;
        }

        result = new TreeNode(node.val);
        TreeNode left = dfs(node.right);
        TreeNode right = dfs(node.left);
        if (left != null) {
            result.left = left;
        }
        if (right != null) {
            result.right = right;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nodeVals = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeMaker.construct(nodeVals);
        TreeNode result = mirrorTree(root);
        TreeMaker.printTree(result);

    }
}
