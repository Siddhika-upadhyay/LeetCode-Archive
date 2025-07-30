class Solution {

    //recursion:
    // public int f(int ind,int tar,int []coins){
    //    if(ind ==0){
    //     if(tar%coins[0]==0)return tar/coins[0];
    //     else return (int)1e9;
    //    }
    //    int notpick=0+f(ind-1,tar,coins);
    //    int pick= Integer.MAX_VALUE;
    //    if(coins[ind]<=tar)pick=1+f(ind,tar-coins[ind],coins);
    //    return Math.min(notpick,pick);
    // }
    // public int coinChange(int[] coins, int amount) {
    //     int n= coins.length;
    //    int res=  f(n-1,amount,coins);
    //    if(res>=(int)1e9)return -1;
    //    else return res;
    // }

    //memoization:
    //  public int f(int ind,int tar,int []coins,int [][]dp){
    //    if(ind ==0){
    //     if(tar%coins[0]==0)return tar/coins[0];
    //     else return (int)1e9;
    //    }
    //    if(dp[ind][tar]!=-1)return dp[ind][tar];
    //    int notpick=0+f(ind-1,tar,coins,dp);
    //    int pick= Integer.MAX_VALUE;
    //    if(coins[ind]<=tar)pick=1+f(ind,tar-coins[ind],coins,dp);
    //    return  dp[ind][tar]=Math.min(notpick,pick);
    // }
    // public int coinChange(int[] coins, int amount) {
    //     int n= coins.length;
    //     int [][]dp= new int[n][amount+1];
    //     for(int []row: dp){
    //         Arrays.fill(row,-1);
    //     }
    //    int res=  f(n-1,amount,coins,dp);
    //    if(res>=(int)1e9)return -1;
    //    else return res;
    // }

    //tabulation:
    // public int coinChange(int[] coins, int amount) {
    //     int n= coins.length;
    //     int [][]dp= new int[n][amount+1];
    //     for(int t=0;t<=amount;t++){
    //         if(t%coins[0]==0)dp[0][t]=t/coins[0];
    //         else dp[0][t]=(int)1e9;
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         for(int tar=0;tar<=amount;tar++){
    //             int notpick=0+dp[ind-1][tar];
    //             int pick= Integer.MAX_VALUE;
    //             if(coins[ind]<=tar)pick=1+dp[ind][tar - coins[ind]];
    //             dp[ind][tar]=Math.min(notpick,pick);
    //         }
    //     }
    //    int res=  dp[n-1][amount];
    //    if(res>=(int)1e9)return -1;
    //    else return res;
    // }

    //space optimized:

    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int []prev= new int[amount+1];
        int []curr= new int[amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)prev[t]=t/coins[0];
            else prev[t]=(int)1e9;
        }
        for(int ind=1;ind<n;ind++){
            for(int tar=0;tar<=amount;tar++){
                int notpick=0+prev[tar];
                int pick= Integer.MAX_VALUE;
                if(coins[ind]<=tar)pick=1+curr[tar - coins[ind]];
                curr[tar]=Math.min(notpick,pick);
            }
            prev=curr;
        }
       int res=  prev[amount];
       if(res>=(int)1e9)return -1;
       else return res;
    }
}