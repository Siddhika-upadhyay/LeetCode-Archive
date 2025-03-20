class Solution {
    public int atmostSum(int[] nums, int k){
        int right=0,left=0,count=0,n=nums.length, sum=0;
        while(right<n){
            sum+=nums[right];
              while (sum > k) {
                sum -= nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       if (goal == 0) {
    return atmostSum(nums, 0);
} else {
    return atmostSum(nums, goal) - atmostSum(nums, goal - 1);
}
    }
}