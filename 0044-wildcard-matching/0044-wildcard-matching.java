class Solution {
    //recursion:

    // private boolean f(int i,int j ,String s,String p){
    //    //base case:
    //     if(i<0 &&j<0)return true;
    //     if(j<0&&i>=0)return false;
    //      if(i<0&&j>=0){
    //         for(int k=0;k<=j;k++){
    //             if(p.charAt(k)!='*')return false;
    //         }
    //         return true;
    //      }
    //     if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?') return f(i-1,j-1,s,p);
    //     else {
    //         if(p.charAt(j)=='*')return f(i,j-1,s,p)||f(i-1,j,s,p);
    //         else return false;
    //     }
    // }
    // public boolean isMatch(String s, String p) {
    //     int n= s.length();
    //     int m= p.length();
    //     return f(n-1,m-1,s,p);
    // }

    //memoization:
    // private boolean f(int i, int j, String s, String p, int[][] dp) {
    //     // base cases
    //     if (i <0 && j < 0) return true;
    //     if (j < 0 && i >= 0) return false;
    //     if (i < 0 && j >= 0) {
    //         for (int k = 0; k <= j; k++) {
    //             if (p.charAt(k) != '*') return false;
    //         }
    //         return true;
    //     }
    //     if (dp[i][j] != -1) return dp[i][j] == 1;
    //     boolean ans;
    //     if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
    //         ans = f(i - 1, j - 1, s, p, dp);
    //     } else if (p.charAt(j) == '*') {
    //         ans = f(i, j - 1, s, p, dp) || f(i - 1, j, s, p, dp);
    //     } else {
    //         ans = false;
    //     }
    //     dp[i][j] = ans ? 1 : 0;
    //     return ans;
    // }
    // public boolean isMatch(String s, String p) {
    //     int n = s.length();
    //     int m = p.length();
    //     int[][] dp = new int[n][m];
    //     for (int[] row : dp) Arrays.fill(row, -1);
    //     return f(n - 1, m - 1, s, p, dp);
    // }

    //tabulation:
    // public boolean isMatch(String s, String p) {
    //     int n = s.length();
    //     int m = p.length();
    //     boolean[][] dp = new  boolean[n+1][m+1];
    //     dp[0][0]=true;
    //     //pattern is empty:
    //     for(int i=1;i<=n;i++)dp[i][0]=false;
    //     //string is empty:
    //     for(int j=1;j<=m;j++){
    //         boolean flag= true;
    //         for(int it=1;it<=j;it++){
    //             if(p.charAt(it-1)!='*')flag= false;
    //         }
    //         dp[0][j]=flag;
    //     } 
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //              if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
    //                 dp[i][j]= dp[i - 1][ j - 1];
    //             } else if (p.charAt(j-1) == '*') {
    //                 dp[i][j]= dp[i][ j - 1] || dp[i - 1][j];
    //             } else {
    //                 dp[i][j]= false;
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }

    //space optimization:
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[]prev = new  boolean[m+1];
         boolean[]curr = new  boolean[m+1];
        prev[0]=true;
        //string is empty:
        for(int j=1;j<=m;j++){
            boolean flag= true;
            for(int it=1;it<=j;it++){
                if(p.charAt(it-1)!='*')flag= false;
            }
            prev[j]=flag;
        } 
        for(int i=1;i<=n;i++){
            curr[0]=false;
            for(int j=1;j<=m;j++){
                 if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    curr[j]= prev[ j - 1];
                } else if (p.charAt(j-1) == '*') {
                    curr[j]= curr[ j - 1] || prev[j];
                } else {
                    curr[j]= false;
                }
            }
            prev=curr.clone();
        }
        return prev[m];
    }
}