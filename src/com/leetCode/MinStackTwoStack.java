package com.leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class MinStackTwoStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStackTwoStack() {
    }

    public void push(int x) {
        if(min.isEmpty() || x < min.peek()){
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}


class UtiliseMinStack{
    public static void main(String args[]){
        MinStackTwoStack obj = new MinStackTwoStack();
        int x = 3;
        obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}