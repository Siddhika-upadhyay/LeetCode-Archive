class Solution {
    // public int maxProfit(int[] prices) {
    //     int totalProfit =0;
    //     for (int i = 1; i < prices.length; i++) {
           
    //         if (prices[i] > prices[i - 1]) {
    //             totalProfit += prices[i] - prices[i - 1]; 
    //         }
    //     }
        
    //     return totalProfit; 
    // }

    //dynamic programming :
    //recursion:
//     private int f(int ind,int buy, int []prices ){
//     int n=prices.length;
//     if(ind==n)return 0;
//     if(buy==1){
//         return Math.max((-prices[ind]+f(ind+1,0,prices)),f(ind+1,1,prices));
//     }
//     else{
//         return Math.max((prices[ind]+f(ind+1,1,prices)),f(ind+1,0,prices));
//      }
//    }
//    public int maxProfit(int[] prices) {
//         return f(0,1,prices);
//     }

//memoization:
    // private int f(int ind,int buy,int []prices, int [][]dp){
    //     int n=prices.length;
    //     if(ind==n)return 0;
    //     if(dp[ind][buy]!=-1)return dp[ind][buy];
    //     if(buy==1){
    //         return Math.max((-prices[ind]+f(ind+1,0,prices,dp)),f(ind+1,1,
    //         prices,dp));
    //     }
    //     else{
    //         return Math.max((prices[ind]+f(ind+1,1,prices,dp)),f(ind+1,0,
    //         prices,dp));
    //     }
    // }
    //     public int maxProfit(int[] prices) {
    //         int n= prices.length;
    //         int dp[][]=new int [n][2];
    //             for(int []col:dp){
    //                 Arrays.fill(col,-1);
                
    //         }
    //             return f(0,1,prices,dp);
    //         }

    //tabulation:
    
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     int[][] dp = new int[n + 1][2]; 
    //     for (int ind = n - 1; ind >= 0; ind--) {
    //         for (int buy = 0; buy <= 1; buy++) {
    //             if (buy == 1) {
    //                 dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
    //             } else {
    //                 dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);
    //             }
    //         }
    //     }

    //     return dp[0][1];
    // }
     public int maxProfit(int[] prices) {
      int n = prices.length;
        int[] ahead = new int[2]; 
        int[] curr = new int[2]; 

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[ind] + ahead[0], ahead[1]);
                } else {
                    curr[buy] = Math.max(prices[ind] + ahead[1], ahead[0]);
                }
            }
            ahead = curr.clone();
        }

        return ahead[1]; 
    }
}