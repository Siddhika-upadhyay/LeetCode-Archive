class Solution {
    //recursion:
    // public int f(int ind,int amt,int[]coins){
    //     if(amt==0)return 1;
    //     if(ind==0){
    //        return amt % coins[ind] == 0 ? 1 : 0;
    //     }
    //     int notpick=f(ind-1,amt,coins);
    //     int pick=0;
    //     if(coins[ind]<=amt)pick=f(ind,amt-coins[ind],coins);
    //     return pick+notpick;
    // }
    // public int change(int amount, int[] coins) {
    //   int n= coins.length;
    //   return f(n-1,amount,coins);
    // }

    //memoization:

    // public int f(int ind,int amt,int[]coins,int [][] dp){
    //     if(amt==0)return 1;
    //     if(ind==0){
    //        return amt % coins[ind] == 0 ? 1 : 0;
    //     }
    //     if(dp[ind][amt]!=-1)return dp[ind][amt];
    //     int notpick=f(ind-1,amt,coins,dp);
    //     int pick=0;
    //     if(coins[ind]<=amt)pick=f(ind,amt-coins[ind],coins,dp);
    //     return dp[ind][amt]= pick+notpick;
    // }
    // public int change(int amount, int[] coins) {
    //   int n= coins.length;
    //   int dp[][]= new int [n][amount+1];
    //   for(int [] row:dp){
    //     Arrays.fill(row,-1);
    //   }
    //   return f(n-1,amount,coins,dp);
    // }

    //tabulation:
    // public int f(int ind,int amt,int[]coins,int [][] dp){
    //     if(amt==0)return 1;
    //     if(ind==0){
    //        return amt % coins[ind] == 0 ? 1 : 0;
    //     }
    //     if(dp[ind][amt]!=-1)return dp[ind][amt];
    //     int notpick=f(ind-1,amt,coins,dp);
    //     int pick=0;
    //     if(coins[ind]<=amt)pick=f(ind,amt-coins[ind],coins,dp);
    //     return dp[ind][amt]= pick+notpick;
    // }
    // public int change(int amount, int[] coins) {
    //   int n= coins.length;
    //   int dp[][]= new int [n][amount+1];
    //   for (int i = 0; i <= amount; i++) {
    //         if (i%coins[0] == 0)
    //             dp[0][i] = 1;
    //     }
    //   for(int ind=1;ind<n;ind++){
    //     for(int amt=0;amt<=amount;amt++){
    //         int notpick=dp[ind-1][amt];
    //     int pick=0;
    //     if(coins[ind]<=amt)pick=dp[ind][amt-coins[ind]];
    //      dp[ind][amt]= pick+notpick;
    //     }
    //   }
    //   return dp[n-1][amount];
    // }

  //space optimization:

    public int change(int amount, int[] coins) {
      int n= coins.length;
      int prev[]= new int [amount+1];
      for (int i = 0; i <= amount; i++) {
            if (i%coins[0] == 0)
                prev[i] = 1;
        }
      for(int ind=1;ind<n;ind++){
        int curr[]= new int [amount+1];
        for(int amt=0;amt<=amount;amt++){
            int notpick=prev[amt];
        int pick=0;
        if(coins[ind]<=amt)pick=curr[amt-coins[ind]];
         curr[amt]= pick+notpick;
        }
        prev=curr;
      }
      return prev[amount];
    }
}