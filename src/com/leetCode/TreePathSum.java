package com.leetCode;

public class TreePathSum {
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

    public static void main(String args[]){
        TreeNode sample = new TreeNode(1);
        sample.left = new TreeNode(2);
        int sum = 1;
        System.out.println(hasPathSum(sample,sum));
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }else if(root.left == null && root.right == null && sum-root.val == 0){
            return true;
        }else{
            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        }
    }

    public static boolean checkPath(TreeNode root, int sum) {
        if(root == null){
            return sum == 0;
        }

        return checkPath(root.left,sum-root.val) || checkPath(root.right, sum-root.val);
    }
}
