package ArraysAndLinkedLists.Arrays;


public class Trading {
    public static void profitStock(int[] arr){
        int maxSelPrice = Integer.MIN_VALUE;
        int minBuyPrice = Integer.MAX_VALUE;
        int maxSellDay = 0;
        int minBuyDay = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minBuyPrice){
                minBuyPrice = arr[i];
                minBuyDay = i;
            }
            if(i != 0 && arr[i] > maxSelPrice){
                if(minBuyDay > maxSellDay){
                    maxSellDay = minBuyDay;
                    maxSelPrice = arr[minBuyDay];
                    continue;
                }
                maxSelPrice = arr[i];
                maxSellDay = i;
            }
        }
        System.out.printf("Buy at Day: %d (at Price: %d)\n", minBuyDay+1, minBuyPrice);
        System.out.printf("Sell at Day: %d (at Price: %d)\n", maxSellDay+1, maxSelPrice);
        System.out.printf("Profit: %d", maxSelPrice - minBuyPrice);
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        profitStock(arr);
    }
}
