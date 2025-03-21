class Solution {
    public int atMost(int[] nums, int k) {
     int n= nums.length;
        int right=0, left=0;
        int count=0;
        int oddCount=0;
        while(right < n){
            if(nums[right] % 2 != 0) oddCount++;
            while(oddCount > k) {
                if(nums[left] % 2 != 0){
                    oddCount--;
                }
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
}