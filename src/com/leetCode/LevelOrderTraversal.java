package com.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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
        printResult(levelOrder(sample));
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        if(root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
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
                al.add(nodeValues);
                nodeValues = new ArrayList();
            }

        }
        return al;
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root)
    {
        //Queue to traverse level by level
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)
            return ans;
        q.add(root);

        while(!q.isEmpty())
        {
            //get the num of nodes in the current level
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();

            //iterate and add to list
            for(int i=0; i<size; i++)
            {
                TreeNode node = q.poll();
                list.add(node.val);
                // add node's child to queue
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);

            }
            ans.add(list);
        }
        return ans;

    }
}
