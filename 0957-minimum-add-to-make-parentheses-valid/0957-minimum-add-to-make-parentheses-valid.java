class Solution {
    public int minAddToMakeValid(String s) {
        int len= s.length();
        int open=0,close=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='(')open++;
            else {
                if(open==0)close++;
                else open--;
            }
        }
        return open+close;
    }
}