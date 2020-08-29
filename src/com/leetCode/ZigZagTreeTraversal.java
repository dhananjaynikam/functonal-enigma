package com.leetCode;

import java.util.*;

public class ZigZagTreeTraversal {
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
        List<List<Integer>> answer = zigzagLevelOrder(sample);
        for(List a : answer){
            for(Object b : a){
                System.out.print(b+",");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        //return list of list
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        //declare queue
        Queue<TreeNode> queue = new LinkedList<>();

        //add root to queue
        queue.offer(root);

        //declare zig zag var
        boolean zigzag  = false;
        //while q is not empty
        while(!queue.isEmpty()) {
            //declare level list and size from q
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                //poll from q
                TreeNode node = queue.poll();

                if (zigzag) {
                    level.add(0, node.val);

                } else {

                    level.add(node.val);
                }

                //check if left not null add to queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
        //T O(n) S O(n)
    }
}
