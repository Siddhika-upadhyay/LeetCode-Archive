class Solution {
    //recursion-tle
    // public int  f(int row,int col){
    //     if(row==0&&col==0){
    //         return 1;
    //     }
    //.     if(col<0||row<0)return 0;
    //     int left=0,up=0;
    //      left=f(row,col-1);
    //     up=f(row-1,col);
    //     return up+left;
    // }
    // public int uniquePaths(int m, int n) {
    //   return f(m-1,n-1);
    // }

   //memoization:
    //  public int  f(int row,int col,int[][]dp){
    //     if(row==0&&col==0){
    //         return 1;
    //     }
    //     if(col<0||row<0)return 0;
    //     if(dp[row][col]!=-1)return dp[row][col];
    //     int left=0,up=0;
    //      left=f(row,col-1,dp);
    //     up=f(row-1,col,dp);
    //     return dp[row][col]= up+left;
    // }
    // public int uniquePaths(int m, int n) {
    //    int[][] dp = new int[m][n];
    //    for (int[] row : dp) Arrays.fill(row, -1);
    //    return f(m-1,n-1,dp);
    // }

  //tabulation
    // public int uniquePaths(int m, int n) {
    //    int[][] dp = new int[m][n];
    //   for(int row=0;row<m;row++){
    //     for(int col=0;col<n;col++){
    //         if(row==0||col==0){dp[row][col]=1; continue;}
    //             int up=0,left=0;
    //             if(col>0) left=dp[row][col-1];
    //             if(row>0) up=dp[row-1][col];
    //             dp[row][col]=left+up;
    //     }
    //   }
    //       return dp[m-1][n-1];
    // }

    //space optimization:
    public int uniquePaths(int m, int n) {
       int[] prev= new int[n];
      for(int row=0;row<m;row++){
        int []temp= new int[n];
        for(int col=0;col<n;col++){
            if(row==0&&col==0){temp[col]=1; continue;}
                int up=0,left=0;
                if(col>0) left=temp[col-1];
                if(row>0) up=prev[col];
                temp[col]=left+up;
        }
        prev=temp;
      }
          return prev[n-1];
    }

}