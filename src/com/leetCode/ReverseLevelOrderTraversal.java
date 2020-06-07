package com.leetCode;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseLevelOrderTraversal {

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

    public static void main(String args[]){
        TreeNode sample = new TreeNode(3);
        sample.left = new TreeNode(9);
        sample.left.left = new TreeNode(5);
        sample.left.right = new TreeNode(6);
        sample.right = new TreeNode(20);
        sample.right.right = new TreeNode(7);
        sample.right.left = new TreeNode(15);
        System.out.println("Tree :");
        printTree(sample);
        System.out.println("Answer :");
        printResult(reverseLevelOrder(sample));
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> a:result
             ) {
            for(int s : a){
                System.out.print(s+" ");
            }
            System.out.println("\n");
        }
    }

        public static void printTree(TreeNode root){
        if(root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            int left_depth = maxDepth(root.left);
            int right_depth = maxDepth(root.right);
            if(left_depth > right_depth) return left_depth +1;
            else return right_depth+1;
        }
    }

    public static List<List<Integer>> reverseLevelOrder(TreeNode root) {
        int maxDept = maxDepth(root);
        List<List<Integer>> al = new ArrayList<>();
        for(int i =0;i<maxDept;i++){
            al.add(new ArrayList<>());
        }
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        if(root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        int counter = maxDept-1;
        while(!current.isEmpty()){
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                al.set(counter,nodeValues);
                counter--;
                nodeValues = new ArrayList();
            }

        }
        return al;
    }
}
