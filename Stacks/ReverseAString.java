package Stacks;

import java.util.Stack;

public class ReverseAString {
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        StringBuilder string = new StringBuilder("");
        while (!st.isEmpty()) {
            string.append(st.pop());
        }
        return string.toString();
    }
    public static void main(String[] args) {
        String str = "abc";
        str = reverseString(str);
        System.out.println(str);
    }
}
