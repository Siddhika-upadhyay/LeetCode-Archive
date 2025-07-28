class Solution {
static Boolean isSubsetSum(int arr[], int sum) {
    int n = arr.length;
    boolean[] prev = new boolean[sum + 1];
    boolean[] curr = new boolean[sum + 1];
    prev[0] = true;
    if (arr[0] <= sum)
        prev[arr[0]] = true;
    for (int ind = 1; ind < n; ind++) {
        curr[0] = true; 
        for (int target = 1; target <= sum; target++) {
            boolean notTake = prev[target];
            boolean take = false;
            if (arr[ind] <= target)
                take = prev[target - arr[ind]];
            curr[target] = take || notTake;
        }
        prev = curr.clone();
    }
    return prev[sum];
}
    public boolean canPartition(int[] nums) {
         int n= nums.length;
         int sum=0;
         for(int i=0;i<n;i++){
            sum+=nums[i];
         }
         if(sum%2!=0)  return false;
         int requiredSum=sum/2;
         return isSubsetSum(nums,requiredSum);
    }
}