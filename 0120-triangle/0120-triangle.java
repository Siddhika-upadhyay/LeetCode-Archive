class Solution {
    //recursion sol:
    // public int f(int i,int j, List<List<Integer>>triangle,int n){
    //     if(i==n-1)return triangle.get(i).get(j);
    //     int down=0,diagonal=0;
    //     down = triangle.get(i).get(j)+ f(i+1,j,triangle,n);
    //     diagonal = triangle.get(i).get(j)+ f(i+1,j+1,triangle,n);
    //     return Math.min(down,diagonal);
    // }
    // public int minimumTotal(List<List<Integer>> triangle) {
    // int n=triangle.size();
    //  return f(0,0,triangle,n);
    // }

    //memoization:
    // public int f(int i,int j, List<List<Integer>>triangle,int n,int [][]dp){
    //     if(i==n-1)return triangle.get(i).get(j);
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int down=0,diagonal=0;
    //     down = triangle.get(i).get(j)+ f(i+1,j,triangle,n,dp);
    //     diagonal = triangle.get(i).get(j)+ f(i+1,j+1,triangle,n,dp);
    //     return dp[i][j]=Math.min(down,diagonal);
    // }
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int [][]dp= new int[n][n];
    //     for(int []row: dp) Arrays.fill(row,-1);
    //     return f(0,0,triangle,n,dp);
    // }

    //tabulation:

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int [][]dp= new int[n][n];
    //     for(int j=0;j<n;j++){
    //         dp[n-1][j]=triangle.get(n-1).get(j);
    //     }
    //    for(int i=n-2;i>=0;i--){
    //     for(int j=i;j>=0;j--){
    //         int down=0,diagonal=0;
    //         down = triangle.get(i).get(j)+ dp[i+1][j];
    //         diagonal = triangle.get(i).get(j)+ dp[i+1][j+1];
    //         dp[i][j]=Math.min(down,diagonal);
    //     }
    //    }
    //    return dp[0][0];
    // }

    //space optimization :

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n=triangle.size();
    //     int []dp= new int[n];
    //     for(int j=0;j<n;j++){
    //         dp[j]=triangle.get(n-1).get(j);
    //     }
    //    for(int i=n-2;i>=0;i--){
    //     int []temp= new int[n];
    //     for(int j=i;j>=0;j--){
    //         int down=0,diagonal=0;
    //         down = triangle.get(i).get(j)+ dp[j];
    //         diagonal = triangle.get(i).get(j)+ dp[j+1];
    //         temp[j]=Math.min(down,diagonal);
    //     }
    //     dp=temp;
    //    }
    //    return dp[0];
    // }

    //without including temp:

    public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n];
    for (int j = 0; j < n; j++) {
        dp[j] = triangle.get(n - 1).get(j);
    }
    for (int i = n - 2; i>= 0; i--) {
        for (int j = 0; j<= i; j++) {
            dp[j] =triangle.get(i).get(j)+ Math.min(dp[j], dp[j + 1]);
        }
    }
    return dp[0];
     }
}