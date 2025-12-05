class Solution {
    public int countPartitions(int[] nums) {
        int n= nums.length;
        int[]prefixSum = new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int count=0;
        for( int i=0;i<n-1;i++){
            int diff=prefixSum[n-1]-2*prefixSum[i];
            if(diff%2==0){
                count++;
            }
        }
        return count;
    }
}