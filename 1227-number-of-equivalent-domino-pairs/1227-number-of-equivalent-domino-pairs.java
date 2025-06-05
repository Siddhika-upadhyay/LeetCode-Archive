class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n=dominoes.length;
        int[] freq=new int[1000];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(dominoes[i][0]>dominoes[i][1]){
                int t=dominoes[i][0];
                dominoes[i][0]=dominoes[i][1];
                dominoes[i][1]=t;
            }
            int k=dominoes[i][0]*10+dominoes[i][1];
            cnt+=freq[k];
            freq[k]++;
        }
        return cnt;
    }
}