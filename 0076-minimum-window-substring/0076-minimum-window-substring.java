class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        int need[]= new int [128];
        for(char c: t.toCharArray()){
            need[c]++;
        }
        int count= t.length();
        int l=0; int r=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        while(r<s.length()){
            char right= s.charAt(r);
            if(need[right]>0){
                count--;
            }
          need[right]--;
          r++;
            while(count==0){
                if(r-l<minLen){
                    minLen= r-l;
                    start= l;
                }
                char temp= s.charAt(l);
                need[temp]++;
                if (need[temp] > 0) count++;
                l++;
            }
            
        }
     return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);

    }
}