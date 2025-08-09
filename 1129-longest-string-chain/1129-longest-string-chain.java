class Solution {
    private boolean compare(String s1,String s2){
        if(s1.length()!=s2.length()+1)return false;
        int i=0,j=0;
        while(i<s1.length()){
            if(j<s2.length()&&s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }
         return ( j == s2.length())?true:false;
    }
    public int longestStrChain(String[] words) {
        int n= words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxL=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<n;prev++){
                if(compare(words[i],words[prev])&&1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            maxL=Math.max(maxL,dp[i]);
        }
        return maxL;
    }
}