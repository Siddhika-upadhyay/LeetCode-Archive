class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int maxlen=0;
        int right=0,left=0;
        int []count=new int[26];
         int maxfreq=0;

        while(right<n){
                count[s.charAt(right)-'A']++;
               maxfreq=Math.max(maxfreq,count[s.charAt(right)-'A']);
               if(((right-left+1)-maxfreq)>k){
               count[s.charAt(left)-'A']--;
                left++;
               }
               maxlen=Math.max(maxlen,right-left+1);
               right=right+1;
        }
        return maxlen;
    }
}