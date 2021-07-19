package com.wsx.binaryTree.leetcode_101;
import java.util.LinkedList;
import java.util.List;

import com.wsx.binaryTree.util.*;


/**
 * @author shuangxing.wang
 * @date 2021/7/13
 * 对称二叉树判断
 */
public class leetcode_101 {
    public static void main(String[] args) {
        TreeNode root = TreeMaker.construct(new int[]{1,1});
        isSymmetric(root);


    }
    public static boolean isSymmetric(TreeNode root) {
        return bfs(root);

    }

    public static boolean bfs(TreeNode node) {
        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> checkQueue = new LinkedList<>();

        TreeNode currentNode = node;
        queue.add(currentNode);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                currentNode = queue.remove(0);
                if (currentNode.left != null){
                    queue.add(currentNode.left);
                    checkQueue.add(currentNode.left);
                }else{
                    checkQueue.add(null);
                }

                if (currentNode.right != null){
                    queue.add(currentNode.right);
                    checkQueue.add(currentNode.right);
                }else{
                    checkQueue.add(null);
                }
            }
            System.out.println(check(checkQueue) + " " + checkQueue);
            if (!check(checkQueue)) {
                return false;
            }
            checkQueue.clear();
        }
        return true;
    }

    public static boolean check(List<TreeNode> queue){
        if (queue.size() <= 1) {
            return true;
        }
        if ((queue.size() & 1) == 1) {
            return false;
        }
        int leftPointer = 0;
        int rightPointer = queue.size()-1;
        while (leftPointer < rightPointer){
            if (!queue.get(leftPointer).equals(queue.get(rightPointer))) {
                return false;
            }
            leftPointer ++;
            rightPointer --;
        }
        return true;
    }
}
