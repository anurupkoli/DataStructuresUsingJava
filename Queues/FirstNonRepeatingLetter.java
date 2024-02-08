package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingLetter {
    public static void findNonRepeatingLetter(String str){
        int[] freq = new int[26];
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            que.add(ch);
            freq[ch - 'a']++;
            
            while (!que.isEmpty() && freq[que.peek() - 'a'] > 1) {
                que.remove();
            }

            if(que.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(que.peek() + " ");
            }
        }
        System.out.println();

    }
    public static void main(String[] args) {
        String str = "aabccxb";
        findNonRepeatingLetter(str);
    }
}
