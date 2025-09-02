class Solution {
    public int atmostk(int []nums,int k){
        int n= nums.length;
        int []freq= new int[n+1];
        int distinct=0,count=0;
        int l=0,r=0;
        while(r<n){
            if(freq[nums[r]]==0)distinct++;
            freq[nums[r]]++;
          while (distinct > k) {
                freq[nums[l]]--;          
                if (freq[nums[l]] == 0) { 
                    distinct--;                
                }
                l++;                     
           }
            count += (r-l);
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostk(nums,k)-atmostk(nums,k-1);
}}