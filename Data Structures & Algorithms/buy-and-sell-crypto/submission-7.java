class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            profit = prices[i] - buyPrice;
            if(profit < 0){
                buyPrice = prices[i];
            }
            result = Math.max(result, profit);
        }

        return result;
    }
}
