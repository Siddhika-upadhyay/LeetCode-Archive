class Solution {
    //recusive solution:
    // public int f(int i,int j ,int [][]matrix , int n){
    //     if(i==n-1)return matrix[i][j];
    //     int down=0 , diagonalL=0, diagonalR=0;
    //     down = matrix[i][j]+f(i+1,j,matrix,n);
    //     diagonalL = (j>0) ? matrix[i][j]+f(i+1,j-1,matrix,n):Integer.MAX_VALUE;
    //     diagonalR=(j<n-1) ?matrix[i][j]+f(i+1,j+1,matrix,n):Integer.MAX_VALUE;
    //     return Math.min(down,Math.min(diagonalR,diagonalL));
    // }
    // public int minFallingPathSum(int[][] matrix) {
    //     int n= matrix.length;
    //     int minSum=Integer.MAX_VALUE;
    //     for (int j = 0; j < n; j++) {
    //         minSum = Math.min(minSum, f(0, j, matrix, n));
    //     }
    //     return minSum;
    // }

    //memoization 

    // public int f(int i,int j ,int [][]matrix , int n,int[][]dp){
    //     if (j < 0 || j >= n) return (int)1e9; 
    //     if (i == n - 1) return matrix[n - 1][j];     
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     int down=0 , diagonalL=0, diagonalR=0;
    //     down = matrix[i][j]+f(i+1,j,matrix,n,dp);
    //     diagonalL = matrix[i][j]+f(i+1,j-1,matrix,n,dp);
    //     diagonalR=matrix[i][j]+f(i+1,j+1,matrix,n,dp);
    //     return dp[i][j]=Math.min(down,Math.min(diagonalR,diagonalL));
    // }
    // public int minFallingPathSum(int[][] matrix) {
    //     int n= matrix.length;
    //     int [][] dp= new int [n][n];
    //     for(int[] row: dp){
    //         Arrays.fill(row,-1);
    //     }
    //     int minSum=Integer.MAX_VALUE;
    //     for (int j = 0; j < n; j++) {
    //         minSum = Math.min(minSum, f(0, j, matrix, n,dp));
    //     }
    //     return minSum;
    // }

    //tabulation:

    // public int minFallingPathSum(int[][] matrix) {
    //     int n= matrix.length;
    //     int [][]dp= new int [n][n];
    //     for(int j=0;j<n;j++){
    //         dp[n-1][j]=matrix[n-1][j];
    //     }
    //     int minSum=Integer.MAX_VALUE;
    //    for(int i=n-2;i>=0;i--){
    //     for(int j=n-1;j>=0;j--){ 
    //         int down=0 , diagonalL=0, diagonalR=0;
    //         down = matrix[i][j]+dp[i+1][j];
    //         diagonalL = (j>0) ? matrix[i][j]+dp[i+1][j-1]:Integer.MAX_VALUE;
    //         diagonalR=(j<n-1) ? matrix[i][j]+dp[i+1][j+1]:Integer.MAX_VALUE;
    //         dp[i][j]=Math.min(down,Math.min(diagonalR,diagonalL));
    //     }
    //    }
    //    for(int j=0;j<n;j++){
    //       minSum= Math.min(minSum,dp[0][j]);
    //    }
    //    return minSum;
    // }

    //space optimization :


    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int []dp= new int [n];
        for(int j=0;j<n;j++){
            dp[j]=matrix[n-1][j];
        }
        int minSum=Integer.MAX_VALUE;
       for(int i=n-2;i>=0;i--){
        int[] temp= new int[n];
        for(int j=n-1;j>=0;j--){ 
            int down=0 , diagonalL=0, diagonalR=0;
            down = matrix[i][j]+dp[j];
            diagonalL = (j>0) ? matrix[i][j]+dp[j-1]:Integer.MAX_VALUE;
            diagonalR=(j<n-1) ? matrix[i][j]+dp[j+1]:Integer.MAX_VALUE;
            temp[j]=Math.min(down,Math.min(diagonalR,diagonalL));
        }
        dp=temp;
       }
       for(int j=0;j<n;j++){
          minSum= Math.min(minSum,dp[j]);
       }
       return minSum;
    }
}
