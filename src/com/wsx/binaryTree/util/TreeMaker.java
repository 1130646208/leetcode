package com.wsx.binaryTree.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuangxing.wang
 * @date 2021/7/13
 */
public class TreeMaker {

    /**
     * 由一个整数数组构架二叉树，暂不支持有空节点
     * @param nodeValues 整数数组（二叉树层序遍历结果）
     * @return 构建二叉树的根节点
     */
    public static TreeNode construct(int[] nodeValues){
        if (nodeValues.length == 0){
            return null;
        }
        List<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(0);
        queue.add(root);
        for (int i = 0; i <= nodeValues.length-1; i++) {
            TreeNode currentNode = queue.remove(0);
            currentNode.val = nodeValues[i];

            // has left child
            if (i * 2 + 1 <= nodeValues.length - 1){
                TreeNode left = new TreeNode(0);
                currentNode.left = left;
                queue.add(left);
            }
            // has right child
            if (i * 2 + 2 <= nodeValues.length - 1){
                TreeNode right = new TreeNode(0);
                currentNode.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    /**
     * 按照层序遍历打印二叉树
     * @param root 要打印的二叉树根节点
     */
    public static void printTree(TreeNode root){
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currNode = queue.remove(0);
            System.out.println(currNode);

            if (currNode.left != null){
                queue.add(currNode.left);
            }
            if (currNode.right != null){
                queue.add(currNode.right);
            }
        }
    }
}
