package com.leetCode;

import java.util.Stack;

public class CourseSchedule {
    public static void main(String args[]){
        /*Topological sort is important here. Do no go for a Graph. Graph is an ideal solution but converting an edge list
        to a graph is a pain and there is a constrain that you cannot use an adjacency list.
        Topological sort means the parent node comes before the current node. Or the parent node is visited first and then the
        child node.
         */
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{0,1}};
        System.out.print(canFinish(numCourses,prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites){
        int [] inDegree = new int[numCourses];
        int count = 0;
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++; //increment the number of prerequisites for each vertex For Example : prerequisite = [0,1] and [1,0] | inDegree[0] = 1 | inDegree[1] = 1
            //gets a list of all the courses that have a prerequisite
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<inDegree.length;i++){
            if(inDegree[i] == 0){
                stack.push(i); //push all the courses that do not have a prerequisite
            }
        }

        //get all the course courses from the stack one by one that marks the courses being completed
        while (!stack.isEmpty()){
            int current = stack.pop();
            count++;

            for(int i = 0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == current){
                    inDegree[prerequisites[i][0]]--; //if the current poped course is a prerequisite for some course then reduce the prerequisite in inDegree by 1 marking that one prerequisite is completed
                    if(inDegree[prerequisites[i][0]] == 0){
                        stack.push(prerequisites[i][0]); // if all the prerequisites are completed the child node is now ready to be completed
                    }
                }
            }
        }
        return count == numCourses; //if the total number of courses popped is equal to the total courses means that all the courses are completed
    }
}
