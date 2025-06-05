class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         int n = nums.length;
        long maxSum = 0, windowSum = 0;
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;

        while (r < n) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                windowSum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            windowSum += nums[r];
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                set.remove(nums[l]);
                windowSum -= nums[l];
                l++;
            }

            r++;
        }

        return maxSum;
    }
}