package ArraysAndLinkedLists.Arrays2D;

public class BinarySearch2D {
    static void searchElement(int[][] arr, int ele){
        int row = 0;
        int col = arr[0].length-1;
        while(row <= arr.length-1 && col >= 0){
            if(arr[row][col] == ele){
                System.out.println("["+row+","+col+"]");
                return;
            }
            if(arr[row][col] > ele){
                col--;
            }
            else if(arr[row][col] < ele){
                row++;
            }
        }
        System.out.println("element not found");
    }
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 9, 10, 11 },
        };
        searchElement(arr, 20);
    }
}
