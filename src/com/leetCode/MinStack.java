package com.leetCode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if(x < min){
            min = x;
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == min){
            min = Integer.MAX_VALUE;
            for(int i = 0; i < stack.size();i++){
                int temp = stack.get(i);
                if(temp < min){
                    min = temp;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class UtiliseMinStack2 {
    public static void main(String args[]) {
        MinStack obj = new MinStack();
        int x = 3;
        obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
