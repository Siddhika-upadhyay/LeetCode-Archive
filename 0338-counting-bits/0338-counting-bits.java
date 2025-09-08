class Solution {
    public int[] countBits(int n) {
        // //O(nlogn) tc:
        // int [] res= new int[n+1];
        // int count=0;
        // for(int i=0;i<=n;i++){
        //     count=0;
        //     //count the set bit:
        //     int num=i;
        //     //logn
        //     while(num!=0){
        //         if((num&1)==1)count++;
        //          num= num>>1;
        //     }
        //     res[i]=count;
        // }
        // return res;

        //optimized answer:dp O(n):
        int []res= new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++){
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}