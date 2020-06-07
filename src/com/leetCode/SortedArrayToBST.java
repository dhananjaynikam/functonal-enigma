package com.leetCode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
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
        int[] nums = new int[]{-10,-3,0,5,9};

        int[] nums2 = new int[]{0,1,2,3,4,5};
        TreeNode sample = new TreeNode(8);
        sample.left = new TreeNode(3);
        sample.right = new TreeNode(10);
        sample.left.left = new TreeNode(1);
        sample.left.right = new TreeNode(6);
        sample.right.right = new TreeNode(14);
        sample.right.right.left = new TreeNode(13);
        insertNode(7,sample);


        TreeNode sample1 = sortedArrayToBST(nums);
        TreeNode sample2 = sortedArrayToBST(nums2);
        printLevelOrder(sample2);
        //printLevelOrder(sample);
    }

    static void printLevelOrder(TreeNode root)
    {
        // Base Case
        if(root == null)
            return;

        // Create an empty queue for level order tarversal
        Queue<TreeNode> q =new LinkedList<TreeNode>();

        // Enqueue Root and initialize height
        q.add(root);


        while(true)
        {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                TreeNode node = q.peek();
                System.out.print(node.val + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
//        if(nums.length == 0){
//            return null;
//        }
//        int mid =  nums.length%2 == 0 ?  (nums.length-1)/2 +1 : (nums.length-1)/2;
//        TreeNode answer = new TreeNode(nums[mid]);
//        int left = mid-1;
//        int right = mid+1;
//        while(left >=0 || right < nums.length) {
//            if (left >= 0) {
//                insertNode(nums[left], answer);
//                left--;
//            }
//            if (right < nums.length){
//                insertNode(nums[right], answer);
//                right++;
//            }
//        }

        TreeNode answer = convertToBST(nums,0,nums.length-1);
        return answer;
    }

    public static TreeNode convertToBST(int[] nums, int start,int end ){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = convertToBST(nums, start, mid-1);
        temp.right = convertToBST(nums,mid+1,end);

        return temp;
    }

    public static void insertNode(int item, TreeNode root){
        if(item < root.val ){
            if(root.left == null){
                root.left = new TreeNode(item);
                return ;
            }else{
                insertNode(item,root.left);
            }
        }else{
            if(root.right == null){
                root.right = new TreeNode(item);
                return ;
            }else{
                insertNode(item, root.right);
            }
        }
    }

}
