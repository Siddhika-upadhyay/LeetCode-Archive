class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1,suffix=1;
        int n= nums.length;
        int maxi =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if (suffix==0) suffix=1;
            prefix= prefix*nums[i];
            suffix= suffix*nums[n-i-1];
        maxi= Math.max(maxi,Math.max(prefix,suffix));
        }
        return maxi;
    }
}