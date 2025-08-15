class Solution {
    // private int f(int i,int []arr,int k,int []dp){
    //     int n= arr.length;
    //     if (i==n) return 0;
    //     if(dp[i]!=-1)return dp[i];
    //     int len=0;
    //     int maxi= Integer.MIN_VALUE;
    //     int maxAns= Integer.MIN_VALUE;
    //     for(int j=i;j<Math.min(i+k,n);j++){
    //         len++;
    //         maxi= Math.max(maxi,arr[j]);
    //         int sum= len*maxi+f(j+1,arr,k,dp);
    //         maxAns=Math.max(maxAns,sum);
    //     }
    //     return  dp[i]=maxAns;
    // }
    // public int maxSumAfterPartitioning(int[] arr, int k) {
    //     int n= arr.length;
    //     int [] dp= new int[n];
    //     Arrays.fill(dp,-1);
    //     return f(0,arr,k,dp);
    // }

    //tabulation:
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n= arr.length;
        int [] dp= new int[n+1];
        for(int i =n-1;i>=0;i--){
                int len=0;
        int maxi= Integer.MIN_VALUE;
        int maxAns= Integer.MIN_VALUE;
        for(int j=i;j<Math.min(i+k,n);j++){
                len++;
                maxi= Math.max(maxi,arr[j]);
                int sum= len*maxi+dp[j+1];
                maxAns=Math.max(maxAns,sum);
        }
          dp[i]=maxAns;
        }
       return   dp[0];
    }
}
