class Solution {
      //     //recursion-tle:
    // public int  f(int row,int col,int [][]grid){
    //     if(row==0&&col==0){
    //         return grid[row][col];
    //     }
    //     if (col < 0 || row < 0) return (int)1e9;
    //     int left=0,up=0;
    //     left= grid[row][col]+f(row,col-1,grid);
    //     up=grid[row][col]+f(row-1,col,grid);
    //     return Math.min(up,left);
    // }
    // public int minPathSum(int[][] grid) {
    //     int n= grid.length;
    //     int m= grid[0].length;
    //   return f(n-1,m-1,grid);
    // }

   //memoization:
    //  public int  f(int row,int col,int [][]grid,int [][]dp){
    //     if(row==0&&col==0){
    //         return grid[row][col];
    //     }
    //     if (col < 0 || row < 0) return (int)1e9;
    //     if(dp[row][col]!=-1)return dp[row][col];
    //     int left=0,up=0;
    //     left= grid[row][col]+f(row,col-1,grid,dp);
    //     up=grid[row][col]+f(row-1,col,grid,dp);
    //     return  dp[row][col]=Math.min(up,left);
    // }
    // public int minPathSum(int[][] grid) {
    //     int n= grid.length;
    //     int m= grid[0].length;
    //     int [][]dp= new int[n][m];
    //     for(int[]row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //   return f(n-1,m-1,grid,dp);
    // }

  //tabulation
    // public int minPathSum(int[][] grid) {
    //     int n= grid.length;
    //     int m= grid[0].length;
    //     int [][]dp= new int[n][m];
    //    for(int row =0;row<n;row++){
    //     for(int col=0;col<m;col++){
    //          if(row==0&&col==0){
    //              dp[row][col]= grid[row][col];
    //              continue;
    //          }
    //          int up=0,left=0;
    //          if(col>0) up = grid[row][col]+dp[row][col-1];
    //          else up = grid[row][col]+(int) Math.pow(10,9);
    //          if(row>0) left = grid[row][col]+dp[row-1][col];
    //          else left = grid[row][col]+(int) Math.pow(10,9);
    //          dp[row][col]= Math.min(up,left);
    //         } 
    //    }
    //    return dp[n-1][m-1];
    // }

    //space optimization:
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int []dp= new int[m];
       for(int row =0;row<n;row++){
        int []temp= new int[m];
        for(int col=0;col<m;col++){
             if(row==0&&col==0){
                 temp[col]= grid[row][col];
                 continue;
             }
             int up=0,left=0;
             if(col>0) left = grid[row][col] + temp[col-1];
             else left = grid[row][col] + (int) Math.pow(10,9);
             if(row>0) up = grid[row][col] + dp[col];
             else up = grid[row][col] + (int) Math.pow(10,9);
             temp[col]= Math.min(up,left);
            } 
            dp=temp;
       }
       return dp[m-1];
    }

}
  