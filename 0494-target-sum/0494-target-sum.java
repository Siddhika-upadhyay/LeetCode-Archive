class Solution {
    public static int findWays(int num[], int tar) {
        int n= num.length;
        int dp[][]= new int [n][tar+1];
       //base cases:
       if (num[0] == 0) {
            dp[0][0] = 2; 
        } else {
            dp[0][0] = 1; 
        }

        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }
       for(int ind=1;ind<n;ind++){
           for(int sum=0;sum<=tar;sum++){
                int notpick= dp[ind-1][sum];
            int pick=0;
            if(num[ind]<=sum) pick= dp[ind-1][sum-num[ind]];
            dp[ind][sum]= (pick+notpick);
           }
       }
       return dp[n-1][tar];
    }
    public int countPartitions(int n,int d,int []arr){
        int totalSum=0;
        for(int it:arr)totalSum+=it;
        if (totalSum-d<0||(totalSum - d)%2!=0)return 0;
        return findWays(arr,(totalSum-d)/2);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        return countPartitions(n,target,nums);
    }
}