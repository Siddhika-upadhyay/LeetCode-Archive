class Solution {
    public int maxChunksToSorted(int[] arr) {
           int mx=arr[0];
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(mx<=arr[i]){
                mx=arr[i];
            }
            if(mx==i){
                ans++;
            }
        }
        return ans;
    }
}