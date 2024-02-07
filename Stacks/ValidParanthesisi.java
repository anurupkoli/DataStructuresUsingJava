package Stacks;

import java.util.Stack;

public class ValidParanthesisi {
    public static boolean checkForParanthesis(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if(chr == '(' || chr == '{' || chr == '[' || chr == '<'){
                stack.push(chr);
            }
            if(chr == ')' || chr == '}' || chr == ']' || chr == '>'){
                int ch = stack.pop();
                if(chr == '(' && ch != ')'){
                    return false;
                }
                if(chr == '{' && ch != '}'){
                    return false;
                }
                if(chr == '[' && ch != ']'){
                    return false;
                }
                if(chr == '<' && ch != '>'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "{[[]][]}";
        System.out.println(checkForParanthesis(str));
    }
}
