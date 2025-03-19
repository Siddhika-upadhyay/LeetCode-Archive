class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,right=0,maxlen=0,countZeros=0;
        int n= nums.length;
        while(right<n){
            if(nums[right]==0){
                countZeros++;
            }
            if(countZeros>k){
                if(nums[left]==0){
                    countZeros--;
                }
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
           right++;
        }
        return maxlen;
    }
}