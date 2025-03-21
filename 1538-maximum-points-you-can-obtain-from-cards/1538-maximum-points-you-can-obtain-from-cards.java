class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n= cardPoints.length;
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<k;i++)lsum+=cardPoints[i];
         int  rindex=n-1;
         maxSum=lsum;
         for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[rindex];
            rindex--;
            maxSum=Math.max(maxSum,(rsum+lsum));
         }
       return maxSum;
    }
}