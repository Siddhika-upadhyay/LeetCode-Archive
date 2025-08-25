class Solution {
    public int minInsertions(String s) {
        int open=0,res=0;
        int i=0;
       while(i<s.length()){
        if(s.charAt(i)=='('){
            open++;
            i++;}
        else{
            if(i+1<s.length()&&s.charAt(i+1)==')')i+=2;
            else{
                res++;
                i++;
            }
            if(open>0)open--;
            else{
                res++;
            }
        }
        
       }
       res+=open*2;
       return res;
    }
}