package hackerRank;

import java.util.Stack;

public class BracesBoolean {
    public static void main(String args[]){
        String s = "{[]}";
        String a = "{([])}";
        String b = "{{{{";
        String c = "}}";
        String d = "";

        System.out.println(checkBraces(s));
        System.out.println(checkBraces(a));
        System.out.println(checkBraces(b));
        System.out.println(checkBraces(c));
        System.out.println(checkBraces(d));

    }

    public static boolean checkBraces(String s){
        if(s == null)
            return false;
        boolean solution = false;
        Stack<Character> openBraces = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '{' || curr == '(' || curr == '[') {
                openBraces.push(curr);
            }else {
                if(openBraces.empty()){
                    return false;
                }
                char stak = openBraces.pop();
                if(curr == '}' && stak != '{')
                    return false;
                if(curr == ')' && stak != '(')
                    return false;
                if(curr == ']' && stak != '[')
                    return false;
            }
        }
        if(openBraces.empty())
            solution = true;

        return solution;
    }
}
