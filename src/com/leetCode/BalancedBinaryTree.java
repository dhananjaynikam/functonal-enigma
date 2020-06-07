package com.leetCode;

public class BalancedBinaryTree {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String args[]) {
        TreeNode sample = new TreeNode(8);
        sample.left = new TreeNode(3);
        sample.right = new TreeNode(10);
        sample.left.left = new TreeNode(1);
        sample.left.right = new TreeNode(6);
        sample.right.right = new TreeNode(14);
        sample.right.right.left = new TreeNode(13);
        System.out.println(isBalanced(sample));
    }

    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        if(getHeight(root) == -1){
            return false;
        }
        return true;
    }

    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left-right) >1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
