class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        int HashS[]= new int[256];
        int HashT[]= new int[256];
        for(int i=0;i<s.length();i++){
            char ch1= s.charAt(i);
            char ch2= t.charAt(i);
            if(HashS[ch1]!=HashT[ch2])return false;
            HashS[ch1]=i+1;
            HashT[ch2]=i+1;
        }
        return true;
    }
}