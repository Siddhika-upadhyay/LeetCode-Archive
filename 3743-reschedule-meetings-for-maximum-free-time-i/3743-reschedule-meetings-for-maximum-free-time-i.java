class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
    int n= startTime.length;
    int gaps[]= new int[n+1];
    //edge case before first and after last
    gaps[0]=startTime[0]-0;
    for(int i=0;i<n-1;i++){
        gaps[i+1]=startTime[i+1]-endTime[i];
    }
    gaps[n]=eventTime-endTime[n-1];
    int start=0,end=0;
    int windowSum=0,maxFreeTime=0;
    //there will be k+1 consecutive freeTime
    while(end<n+1){
        windowSum+=gaps[end];
        if((end-start)+1>k+1){
         windowSum-=gaps[start];
         start++;
        }
        if((end-start)+1==k+1){
            maxFreeTime = Math.max(maxFreeTime,windowSum);
        }
        end++;
    }
    return maxFreeTime;
    }
}