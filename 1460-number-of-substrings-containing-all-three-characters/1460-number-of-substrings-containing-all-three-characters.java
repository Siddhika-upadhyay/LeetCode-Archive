class Solution {
    public int numberOfSubstrings(String s) {
        int left=0, right=0;
        int n= s.length();
        Map <Character,Integer>frq= new HashMap<>();
        int count=0;
        frq.put('a',0);
        frq.put('b',0);
        frq.put('c',0);
        while(right<n){
           char ch= s.charAt(right);
           frq.put(ch,frq.get(ch)+1);
           while(frq.get('a')>0&&frq.get('b')>0&&frq.get('c')>0){
             count+=(n-right);
            char leftCh=s.charAt(left);
            frq.put(leftCh,frq.get(leftCh)-1);
            left++;
           }
           right=right+1;
        }
        return count;
    }
}