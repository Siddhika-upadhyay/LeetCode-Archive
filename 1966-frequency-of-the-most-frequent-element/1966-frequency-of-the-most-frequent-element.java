import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);  
        int n = nums.length;
        long total = 0;   
        int l = 0;      
        int res = 0;     

        for (int r = 0; r < n; r++) {
            total += nums[r]; 
            while ((long)nums[r] * (r - l + 1) - total > k) {
                total -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
