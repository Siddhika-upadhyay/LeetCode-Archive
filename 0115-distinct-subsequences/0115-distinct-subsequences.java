class Solution {
    //recursion
    // private int f(int i,int j,String s,String t){
    //     if(j<0)return 1;
    //     if(i<0)return 0;
    //     if(s.charAt(i)==t.charAt(j)) return f(i-1,j-1,s,t)+f(i-1,j,s,t);
    //     else return f(i-1,j,s,t);
    // }
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m= t.length();
    //     return f(n-1,m-1,s,t);
    // }

    //memoization:
    // private int f(int i,int j,String s,String t,int[][]dp){
    //     if(j<0)return 1;
    //     if(i<0)return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j))return dp[i][j]= f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp);
    //     else return dp[i][j]= f(i-1,j,s,t,dp);
    // }
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m= t.length();
    //     int dp[][]=new int[n][m];
    //     for(int[] row:dp)Arrays.fill(row,-1);
    //     return f(n-1,m-1,s,t,dp);
    // }

    //tabulation:
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m= t.length();
    //     int dp[][]=new int[n+1][m+1];
    //    //base case:
    //    for(int i=0;i<=n;i++)dp[i][0]=1;
    //    for(int j=1;j<=m;j++)dp[0][j]=0;
    //    for(int i=1;i<=n;i++){
    //     for(int j=1;j<=m;j++){
    //         if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    //         else dp[i][j]= dp[i-1][j];
    //     }
    //    }
    //     return dp[n][m];
    // }

    //space optimized:
    // public int numDistinct(String s, String t) {
    //     int n=s.length();
    //     int m= t.length();
    //     int prev[]=new int[m+1];
    //     int curr[]=new int[m+1];
    //    //base case:
    //    prev[0]=curr[0]=1;
    //    for(int i=1;i<=n;i++){
    //     for(int j=1;j<=m;j++){
    //         if(s.charAt(i-1)==t.charAt(j-1)) curr[j]=prev[j-1]+prev[j];
    //         else curr[j]= prev[j];
    //     }
    //     prev=curr.clone();

    //    }
    //     return prev[m];
    // }

    //single row:
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m= t.length();
        int prev[]=new int[m+1];
       //base case:
       prev[0]=1;
       for(int i=1;i<=n;i++){
        for(int j=m;j>=1;j--){
            if(s.charAt(i-1)==t.charAt(j-1)) prev[j]=prev[j-1]+prev[j];
            // else prev[j]= prev[j];
        }
       }
        return prev[m];
    }

}
