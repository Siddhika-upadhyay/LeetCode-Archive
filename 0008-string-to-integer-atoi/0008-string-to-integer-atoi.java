class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()) return 0;
        return helper(s,0,0,1,false);
    }
    private int helper(String s, int index, int result ,int sign,boolean hasSign){
        if(index>=s.length())return result*sign;
        char c= s.charAt(index);
        if(!hasSign&&(c=='-'||c=='+')){
            return helper(s,index+1,result,(c=='-')?-1:1,true);
        }
        if(!Character.isDigit(c)) return result*sign;
        int digit=c-'0';
        if(result > (Integer.MAX_VALUE - digit) / 10) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return helper(s,index+1,result*10+digit,sign,true);
    }
}