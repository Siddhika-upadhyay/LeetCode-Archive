 class Solution {
//     private int f(int ind,int tran,int prices[],int dp[][],int k){
//         if(ind==prices.length||tran==2*k) return 0;
//         if(dp[ind][tran]!=-1) return dp[ind][tran];
//         int profit=0;
//         if(tran%2==0){
//             profit=Math.max(-prices[ind]+f(ind+1,tran+1,prices,dp,k),f(ind+1,tran,prices,dp,k));
//         }
//         else{
//             profit=Math.max(prices[ind]+f(ind+1,tran+1,prices,dp,k),f(ind+1,tran,prices,dp,k));
//         }
//         return dp[ind][tran]=profit;
//     }
//     public int maxProfit(int k, int[] prices) {
//         int n=prices.length;
//         int dp[][]=new int[n][2*k];
//         for(int arr[]:dp){
//             Arrays.fill(arr,-1);
//         }
//         return f(0,0,prices,dp,k);
//     }

// public int maxProfit(int k, int[] prices) {
//         int n=prices.length;
//         int dp[][]=new int[n+1][2*k+1];
//         for(int ind=n-1;ind>=0;ind--){
//             for(int tran=2*k-1;tran>=0;tran--){
//                 int profit=0;
//                 if(tran%2==0){
//                     profit=Math.max(-prices[ind]+dp[ind+1][tran+1],dp[ind+1][tran]);
//                 }
//                 else{
//                     profit = Math.max(prices[ind] + dp[ind + 1][tran + 1], dp[ind + 1][tran]);
//                 }
//                 dp[ind][tran]=profit;
//             }
//         }
//         return dp[0][0];
//  }

public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[]=new int[2*k+1];
        for(int ind=n-1;ind>=0;ind--){
            int cur[]=new int[2*k+1];
            for(int tran=2*k-1;tran>=0;tran--){
                int profit=0;
                if(tran%2==0){
                    profit=Math.max(-prices[ind]+dp[tran+1],dp[tran]);
                }
                else{
                    profit = Math.max(prices[ind] + dp[tran + 1], dp[tran]);
                }
                cur[tran]=profit;
            }
            dp=cur;
        }
        return dp[0];
    }

 }

//class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n= prices.length;
//         int after[][]=new int [2][k+1];
//         int curr[][]=new int [2][k+1];
//         for (int buy = 0; buy <= 1; buy++) {
//         for (int cap = 0; cap <= k; cap++) {
//             after[buy][cap] = 0;
//         }
//     }for (int ind = n - 1; ind >= 0; ind--) {
//     for (int buy = 0; buy <= 1; buy++) {
//         for (int cap = 1; cap <= k; cap++) {
//             if (buy == 1) {
//                 curr[buy][cap] = Math.max(-prices[ind] + after[0][cap], after[1][cap]);
//             } else {
//                 curr[buy][cap] = Math.max(prices[ind] + after[1][cap - 1], after[0][cap]);
//             }
//         }
//     }
//     after = curr;  
// }
//      return after[1][k];          
// }  
//}