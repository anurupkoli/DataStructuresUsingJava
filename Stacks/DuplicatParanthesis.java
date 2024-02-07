package Stacks;

import java.util.Stack;

public class DuplicatParanthesis {
    public static boolean hasDuplicateParanthesis(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }
            if(ch == ')'){
                int count = 0;
                while(stack.peek() != '('){
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+c)";
        System.out.println(hasDuplicateParanthesis(str));
    }
}
