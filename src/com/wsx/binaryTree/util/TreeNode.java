package com.wsx.binaryTree.util;

/**
 * @author shuangxing.wang
 * @date 2021/7/13
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {

        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}