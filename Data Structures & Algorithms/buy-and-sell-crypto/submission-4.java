class Solution {
    public int maxProfit(int[] prices) {
        /*
        Brute force option is to select ith day as a buyDay and keep checking until 
            i+1 to n, what's the max number present
            Do the same for all element till n-1 as a buyDay
            Keep track of max profit
        
        */

        int max = 0;

        for(int i = 0; i < prices.length-1; i++){
            int buyPrice = prices[i];
            for(int j = i+1; j < prices.length; j++){
                int bestSellPrice = prices[j];
                max = Math.max(max, bestSellPrice - buyPrice);
            }
        }

        return max;
    }
}
