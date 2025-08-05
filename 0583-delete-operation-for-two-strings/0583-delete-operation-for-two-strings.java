class Solution {
    private  int f(String s, String r){
    //     int n= s.length();
    //     int m= r.length();
    //     int dp[][]= new int[n+1][m+1];
    //     for(int i=0;i<=n;i++)dp[i][0]=0;
    //     for(int j=0;j<=m;j++)dp[0][j]=0;
    //     for(int ind1=1;ind1<=n;ind1++){
    //         for(int ind2=1;ind2<=m;ind2++){
    //             //match:
    //             if(s.charAt(ind1-1)==r.charAt(ind2-1))dp[ind1][ind2]=1+dp[ind1-1]
    //             [ind2-1];
    //             //not match:
    //             else dp[ind1][ind2]= Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
    //         }
    //     } 
    //     return dp[n][m];
    // }

    //space optimized:
    int n= s.length();
        int m= r.length();
        int prev[]= new int[m+1];
         int curr[]= new int[m+1];
        for(int i=0;i<=m;i++)prev[i]=0;
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                //match:
                if(s.charAt(ind1-1)==r.charAt(ind2-1))curr[ind2]=1+prev[ind2-1];
                //not match:
                else curr[ind2]= Math.max(prev[ind2],curr[ind2-1]);
            }
            prev= curr;
            curr= new int[m+1];
        } 
        return prev[m];
    }
    public int minDistance(String word1, String word2) {
        int k=f(word1,word2);
        int n= word1.length();
        int m= word2.length();
        return n+m-2*k;
    }
}