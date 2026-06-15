class Solution {
    public int maxProfit(int[] prices) {
        // we need a window where the profit is greater than 0 and keep track of max profit so far

        // i.e buy on day one until you're in profit between buyPrice and sellPrice, keep checking next sellPrice. When you encounter loss in sell price then buy again

        int buyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - buyPrice < 0){
                buyPrice = prices[i];
            }

            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
        }

        return maxProfit;
    }
}
