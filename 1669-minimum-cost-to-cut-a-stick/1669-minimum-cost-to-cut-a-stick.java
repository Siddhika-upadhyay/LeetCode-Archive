class Solution {
    //recursion:
    // private int f(int i,int j,ArrayList<Integer> arr){
    //     if(i>j)return 0;
    //     int mini= Integer.MAX_VALUE;
    //     for(int ind=i;ind<=j;ind++){
    //         int ans= arr.get(j+1)-arr.get(i-1)+f(i,ind-1,arr)+f(ind+1,j,arr);
    //         mini= Math.min(mini,ans);
    //     }
    //     return mini;
    // }
    // public int minCost(int n, int[] cuts) {
    //     int len= cuts.length;
    //       ArrayList<Integer> arr = new ArrayList<>(); 
    //       for (int cut : cuts) arr.add(cut);
    //       arr.add(n);
    //       arr.add(0);
    //       Collections.sort(arr);
    //       return f(1,len,arr);
    // }

    //memoization:
    // private int f(int i,int j,ArrayList<Integer> arr,int [][]dp){
    //     if(i>j)return 0;
    //     int mini= Integer.MAX_VALUE;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     for(int ind=i;ind<=j;ind++){
    //         int ans= arr.get(j+1)-arr.get(i-1)+f(i,ind-1,arr,dp)+f(ind+1,j,arr,dp);
    //         mini= Math.min(mini,ans);
    //     }
    //     return dp[i][j]=mini;
    // }
    // public int minCost(int n, int[] cuts) {
    //     int len= cuts.length;
    //       ArrayList<Integer> arr = new ArrayList<>(); 
    //       for (int cut : cuts) arr.add(cut);
    //       int [][]dp= new int [n][n];
    //       for(int []row:dp)Arrays.fill(row,-1);
    //       arr.add(n);
    //       arr.add(0);
    //       Collections.sort(arr);
    //       return f(1,len,arr,dp);
    // }

    //tabulation:
   
    public int minCost(int n, int[] cuts) {
        int len= cuts.length;
          ArrayList<Integer> arr = new ArrayList<>(); 
          for (int cut : cuts) arr.add(cut);
          int[][] dp = new int[len + 2][len + 2];
          arr.add(n);
          arr.add(0);
          Collections.sort(arr);
         for(int i=len;i>=1;i--){
            for(int j=1;j<=len;j++){
                 if (i > j) { 
                continue;
            }
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int ans = arr.get(j + 1) - arr.get(i - 1) + dp[i][ind - 1] +
                    dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }
                dp[i][j] = mini;
            }
         }
            return dp[1][len];
    }

}