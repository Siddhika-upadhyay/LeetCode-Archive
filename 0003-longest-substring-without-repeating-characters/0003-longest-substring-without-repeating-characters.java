class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>st= new HashSet<>();
        int left=0,right=0;
        int n= s.length();
        int maxlen=0;
        while(right<n){
            char ch = s.charAt(right);
            while (st.contains(ch)) {
                st.remove(s.charAt(left));
                left++;
            }
            st.add(ch);
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}