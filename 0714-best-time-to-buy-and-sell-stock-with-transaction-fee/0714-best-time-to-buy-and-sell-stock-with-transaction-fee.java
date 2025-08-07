class Solution {
    public int maxProfit(int[] prices, int fee) {
           int n = prices.length;
        int[] ahead = new int[2]; 
        int[] curr = new int[2]; 

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[ind] + ahead[0], ahead[1]);
                } else {
                    curr[buy] = Math.max(prices[ind]-fee + ahead[1], ahead[0]);
                }
            }
            ahead = curr.clone();
        }

        return ahead[1]; 
    }
}