class Solution {
    public List<String> generateParenthesis(int n) {
        int open=0,close=0;
        String result="";
        List<String>ans=new ArrayList<>();
       parenthesis(ans,result,open,close,n);
       return ans;
    }
    public static void parenthesis(List<String>ans,String result, int  
    open ,int close, int max){
        if(result.length()==2*max){
            ans.add(result);
            return;
        }
        if(open<max){
            parenthesis(ans,result+"(",open+1,close,max);
        }
        if(close<open){
            parenthesis(ans,result+")",open,close+1,max);
        }
    }
}