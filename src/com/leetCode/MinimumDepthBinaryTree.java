package com.leetCode;

public class MinimumDepthBinaryTree {
    public class TreeNode {
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

    public static void main(String args[]){

    }

    public int loop(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;
        return 1+Math.min(minDepth(root.right), minDepth(root.left));
    }

    public int minDepth(TreeNode root){
        if(root == null) return 0;
        return loop(root);
    }
}
