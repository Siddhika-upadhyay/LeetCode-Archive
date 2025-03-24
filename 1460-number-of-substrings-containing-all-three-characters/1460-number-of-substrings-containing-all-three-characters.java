class Solution {
    public int numberOfSubstrings(String s) {
        int left=0, right=0;
        int n= s.length();
       int[]frq=new int[3]; 
        int count=0;
        while(right<n){
           char ch= s.charAt(right);
            frq[ch - 'a']++;
           while (frq[0]>0&&frq[1]>0&&frq[2]>0) {
                count+=(n-right);
                char leftCh=s.charAt(left);
                frq[leftCh - 'a']--; 
                left++;
            }
            right++;
        }
        return count;
    }
}