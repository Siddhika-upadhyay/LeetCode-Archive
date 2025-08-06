class Solution {
    //recursion:
    // private int f(int i,int j,String s,String t){
    //     if(i<0)return j+1;
    //     if(j<0)return i+1;
    //     if(s.charAt(i)==t.charAt(j))return f(i-1,j-1,s,t);
    //     else{
    //         return 1 + Math.min(f(i,j-1,s,t),Math.min(f(i-1,j,s,t),f(i-1,j-1,s,t)));
    //     }
    // }
    // public int minDistance(String word1, String word2) {
    //     int n= word1.length();
    //     int m= word2.length();
    //     return f(n-1,m-1,word1,word2);
    // }

    //memoization:
    // private int f(int i,int j,String s,String t,int[][]dp){
    //     if(i<0)return j+1;
    //     if(j<0)return i+1;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j))return dp[i][j]= f(i-1,j-1,s,t,dp);
    //     else{
    //         return dp[i][j]= 1 + Math.min(f(i,j-1,s,t,dp),Math.min(f(i-1,j,s,t,dp),
    //         f(i-1,j-1,s,t,dp)));
    //     }
    // }
    // public int minDistance(String word1, String word2) {
    //     int n= word1.length();
    //     int m= word2.length();
    //     int [][]dp= new int[n][m];
    //     for(int []row:dp)Arrays.fill(row,-1);
    //     return f(n-1,m-1,word1,word2,dp);
    // }

    //tabulation by doing shifting of index to +1:

    // public int minDistance(String s, String t) {
    //     int n= s.length();
    //     int m= t.length();
    //     int [][]dp= new int[n+1][m+1];
    //     for(int i=0;i<=n;i++)dp[i][0]=i;
    //     for(int j=0;j<=m;j++)dp[0][j]=j;
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //              if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]= dp[i-1][j-1];
    //         else{
    //             dp[i][j]= 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],
    //             dp[i-1][j-1]));
    //         }
    //         }
    //     }
    //     return dp[n][m];
    // }

    //space optimization :

    public int minDistance(String s, String t) {
        int n= s.length();
        int m= t.length();
        int []prev= new int[m+1];
        int []curr= new int[m+1];
        for(int j=0;j<=m;j++)prev[j]=j;
        for(int i=1;i<=n;i++){
            curr[0]=i;
            for(int j=1;j<=m;j++){
                 if(s.charAt(i-1)==t.charAt(j-1)) curr[j]= prev[j-1];
                else{
                    curr[j]= 1 + Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
                }
            }
            prev= curr;
            curr=new int[m+1];
        }
        return prev[m];
    }
}