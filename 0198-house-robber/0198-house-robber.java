class Solution {
    //using recursion with memoization:
    // public int f(int ind,int []nums,int []dp){
    //     if(ind==0)return nums[0];
    //     if(ind<0)return 0;
    //     if(dp[ind]!=-1)return dp[ind];
    //     int pick=nums[ind]+f(ind-2,nums,dp);
    //     int notpick= 0+f(ind-1,nums,dp);
    //     return dp[ind]=Math.max(pick,notpick);
    // }
    // public int rob(int[] nums) {
    //     int n= nums.length;
    //     int[] dp=new int [n];
    //     Arrays.fill(dp,-1);
    //     return f(n-1,nums,dp);
    // }

//tabulation :
    // public int rob(int[] nums) {
    //     int n= nums.length;
    //     int[] dp=new int [n];
    //     Arrays.fill(dp,-1);
    //     dp[0]=nums[0];
    //     for(int i=1;i<n;i++){
    //         int pick=nums[i];
    //         if(i>1) pick+=dp[i-2];
    //         int notpick= 0+dp[i-1];
    //         dp[i]=Math.max(pick,notpick);
    //     }
    //     return dp[n-1];

//space optimizatiin:
      public int rob(int[] nums) {
        int n= nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=prev2;
            int notpick= 0+prev;
            int curri=Math.max(pick,notpick);
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}