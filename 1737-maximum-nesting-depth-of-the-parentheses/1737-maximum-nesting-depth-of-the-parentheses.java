class Solution {
    public int maxDepth(String s) {
        int depth=0,maxDepth=0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='('){
                depth++;
                maxDepth= Math.max(depth,maxDepth);
            }
            else if(ch==')')depth--;
        }
        return maxDepth;
    }
}