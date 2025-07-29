class Solution {
    public int climbStairs(int n) {
         if(n<=1)return 1;
        int prev2=1,prev=2,curr=0;
        for(int i=2;i<n;i++){
            curr=prev+prev2;
            prev2=prev;
            prev=curr;
        }
        return prev;
          //simple logic of fibonacci:
        //    if(n==1)return 1;
        // if(n==2)return 2;
        // int a=1,b=2,c=0;
        // for(int i=3;i<=n;i++){
        //     c=a+b;
        //     a=b;
        //     b=c;
        // }
        // return c;
    }
}