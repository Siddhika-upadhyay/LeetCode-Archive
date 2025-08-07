class Solution {
    // public int maxProfit(int[] prices) {
    //       int n = prices.length;
    //     int[][] dp = new int[n + 2][2]; 
    //     for (int ind = n - 1; ind >=0; ind--) {
    //         for (int buy = 0; buy <= 1; buy++) {
    //             if (buy == 1) {
    //                 dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
    //             } else {
    //                 dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
    //             }
    //         }
    //     }

    //     return dp[0][1];
    // }

    public int maxProfit(int[] prices) {
          int n = prices.length;
        int[][] dp = new int[n + 2][2]; 
        for (int ind = n - 1; ind >=0; ind--) {
                    dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                    dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
                
            
        }

        return dp[0][1];
    }

    //   int n = prices.length;
    //     int[] ahead = new int[2]; 
    //     int[] curr = new int[2]; 
    //     for (int ind = n - 1; ind >= 0; ind--) {
    //         for (int buy = 0; buy <= 1; buy++) {
    //             if (buy == 1) {
    //                 curr[buy] = Math.max(-prices[ind] + ahead[0], ahead[1]);
    //             } else {
    //                 curr[buy] = Math.max(prices[ind] + ahead[1], ahead[0]);
    //             }
    //         }
    //         ahead = curr.clone();
    //     }

    //     return ahead[1]; 
    // }
    
}