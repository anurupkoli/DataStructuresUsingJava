package ArraysAndLinkedLists.ArrayList;

import java.util.ArrayList;

public class PairSum {
    public static void findPair(ArrayList<Integer> arr, int no){
        int leftP = 0;
        int rightP = arr.size() - 1;
        while (leftP < rightP) {
            if(arr.get(leftP) + arr.get(rightP) == no){
                System.out.println(leftP + " " + rightP);
            }
            if(arr.get(leftP) + arr.get(rightP) < no){
                leftP++;
            }
            else{
                rightP--;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        findPair(arr, 5);
    }
}
