class Solution {
    // public int maxProfit(int[] prices) {
    //   int min1=Integer.MAX_VALUE ,min2=Integer.MAX_VALUE ;
    //   int maxp1=0,maxp2=0;
    //   for(int i=0;i<prices.length;i++){
    //     min1=Math.min(min1,prices[i]);
    //     maxp1 = Math.max(maxp1, prices[i] - min1);
    //      min2 = Math.min(min2, prices[i] - maxp1);
    //     maxp2 = Math.max(maxp2, prices[i] - min2);
    //   }
    //   return maxp2;
    // }

   //recursion:
//    private int f(int ind,int buy,int cap, int []prices ){
//     int n=prices.length;
//     if(cap==0)return 0;
//     if(ind==n)return 0;
//     if(buy==1){
//         return Math.max((-prices[ind]+f(ind+1,0,cap,prices)),f(ind+1,1,cap,prices));
//     }
//     else{
//         return Math.max((prices[ind]+f(ind+1,1,cap-1,prices)),f(ind+1,0,cap,prices));
//     }
//    }
//     public int maxProfit(int[] prices) {
//                return f(0,1,2,prices);
//         }

//memo:
    // private int f(int ind,int buy,int cap, int []prices, int [][][]dp){
    //     int n=prices.length;
    //     if(cap==0)return 0;
    //     if(ind==n)return 0;
    //     if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        // if(buy==1){
        //     return dp[ind][buy][cap] = Math.max((-prices[ind]+f(ind+1,0,cap,prices,dp)),f(ind+1,1,cap,
        //     prices,dp));
        // }
        // else{
        //     return dp[ind][buy][cap] = Math.max((prices[ind]+f(ind+1,1,cap-1,prices,dp)),f(ind+1,0,cap,
        //     prices,dp));
        // }
    // }
    //     public int maxProfit(int[] prices) {
    //         int n= prices.length;
    //         int dp[][][]=new int [n][2][3];
    //         for(int [][]rows:dp){
    //             for(int []col:rows){
    //                 Arrays.fill(col,-1);
    //             }
    //         }
    //             return f(0,1,2,prices,dp);
    //         }

    //tabulation:
//     public int maxProfit(int[] prices) {
//         int n= prices.length;
//         int dp[][][]=new int [n+1][2][3];
//         for (int buy = 0; buy <= 1; buy++) {
//         for (int cap = 0; cap <= 2; cap++) {
//             dp[n][buy][cap] = 0;
//         }
//     }
//         for (int ind = n - 1; ind >= 0; ind--) {
//             for (int buy = 0; buy <= 1; buy++) {
//                 for (int cap = 1; cap <= 2; cap++) {
//                   if(buy==1){
//                   dp[ind][buy][cap] =Math.max((-prices[ind]+dp[ind+1][0][cap]),dp[ind
//                   +1][1][cap]);
//                     }
//                   else{
//                     dp[ind][buy][cap] = Math.max((prices[ind]+dp[ind+1][1][cap-1]),dp
//                     [ind+1][0][cap]);
//                     }
//                 }
//             }
//         }  
//         return dp[0][1][2];          
//     }


//space optmization:

 public int maxProfit(int[] prices) {
        int n= prices.length;
        int after[][]=new int [2][3];
        int curr[][]=new int [2][3];
        for (int buy = 0; buy <= 1; buy++) {
        for (int cap = 0; cap <= 2; cap++) {
            after[buy][cap] = 0;
        }
    }for (int ind = n - 1; ind >= 0; ind--) {
    for (int buy = 0; buy <= 1; buy++) {
        for (int cap = 1; cap <= 2; cap++) {
            if (buy == 1) {
                curr[buy][cap] = Math.max(-prices[ind] + after[0][cap], after[1][cap]);
            } else {
                curr[buy][cap] = Math.max(prices[ind] + after[1][cap - 1], after[0][cap]);
            }
        }
    }
    after = curr;  
}
     return after[1][2];          
}

 }