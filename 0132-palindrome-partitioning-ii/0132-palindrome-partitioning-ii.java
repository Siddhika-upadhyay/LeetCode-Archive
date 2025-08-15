class Solution {
    // private boolean isPalindrome(int i, int j ,String s){
    //     while(i<=j){
    //         if(s.charAt(i)!=s.charAt(j))return false;
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    // private int f(int i,int n , String s, int []dp){
    //     if(i==n)return 0;
    //     int mincost=Integer.MAX_VALUE;
    //     if(dp[i]!=-1)return dp[i];
    //     for(int j=i;j<n;j++){
    //         if(isPalindrome(i,j,s)){
    //             int cost= 1+f(j+1,n,s,dp);
    //             mincost= Math.min(mincost ,cost);
    //         }
    //     }
    //     return dp[i]= mincost;
    // }
    // public int minCut(String s) {
    //     int n= s.length();
    //     int dp[]= new int [n];
    //     Arrays.fill(dp,-1);
    //     //done -1 because we have calculated the no. of palindromic part for  
    //     //cuts we will need to subtract by 1
    //     return f(0,n,s,dp)-1;
    // }

    //tabulation:

    private boolean isPalindrome(int i, int j ,String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
   
    public int minCut(String s) {
        int n= s.length();
        int dp[]= new int [n+1];
        for(int i =n-1;i>=0;i--){
            int mincost=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    int cost= 1+dp[j+1];
                    mincost= Math.min(mincost ,cost);
                }
            }
            dp[i]=mincost;
        }
        return dp[0]-1;
    }
}