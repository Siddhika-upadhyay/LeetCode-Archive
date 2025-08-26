class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result="";
        int j=0;
        int n=Math.min(word1.length(),word2.length());
        int i=0;
        for(i=0;i<n;i++){
            result+=word1.charAt(i);
            result+=word2.charAt(i);
        }
       while(i<word1.length()){result+=word1.charAt(i);i++;}
       while(i<word2.length()){result+=word2.charAt(i);i++;}
       return result;
    }
}