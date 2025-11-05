class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        Stack<Character>st= new Stack<>();
        for(char digit:num.toCharArray()){
            while(!st.isEmpty()&& k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
             st.push(digit);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        char result[]= new char[st.size()];
        int index= st.size()-1;
        while(index>=0){
            result[index--]=st.pop();
        }
        //to remove the starting zeros:
        int start=0;
        while(start<result.length && result[start]=='0'){
            start++;
        }
        String finalResult = start == result.length ? "0" : new String(result, 
        start, result.length - start);
        return finalResult;
    }
}