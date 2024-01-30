package ArraysAndLinkedLists.ArrayList;

import java.util.ArrayList;

public class PairSum2 {
    public static void findPair2(ArrayList<Integer> arr, int no){
        int leftP = 0, rightP = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) > arr.get(i+1)){
                leftP = i+1;
                rightP = i;
            }
        }
        while(leftP != rightP){
            if(arr.get(leftP) + arr.get(rightP) == no){
                System.out.println(leftP + "," + rightP);
            }
            if(arr.get(leftP) + arr.get(rightP) < no){
                leftP = (leftP + 1)%arr.size();
            }
            else{
                rightP = (arr.size() + rightP-1)%arr.size();
            }
            // if(arr.get(leftP) + arr.get(rightP) < no){
            //     if(leftP >= arr.size()){
            //         leftP = 0;
            //     }
            //     else{
            //         leftP++;
            //     }
            // }
            // else{
            //     if(rightP <= 0){
            //         rightP = arr.size()-1;
            //     }
            //     else{
            //         rightP--;
            //     }
            // }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        findPair2(arr, 21);
    }
}
