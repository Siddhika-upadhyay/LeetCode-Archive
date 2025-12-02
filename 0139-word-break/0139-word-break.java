class Solution {
    //brute force:
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> dict= new HashSet<>(wordDict);
    //     return helper(0,s,dict);
    // }
    // public boolean helper(int index , String s , Set<String> dict){
    //     if(index==s.length())return true;

    //     for(int i= index+1; i<=s.length();i++){
    //         String part= s.substring(index,i);
    //         if(dict.contains(part)){
    //             if(helper(i, s, dict)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict= new HashSet<>(wordDict);
        int n= s.length();
        Boolean []memo= new Boolean[n];
        return helper(0,s,dict,memo);
    }
    public boolean helper(int index , String s , Set<String> dict,Boolean[]memo){
        if(index==s.length())return true;
        if(memo[index]!=null)return memo[index];

        for(int i= index+1; i<=s.length();i++){
            String part= s.substring(index,i);
            if(dict.contains(part)){
                if(helper(i, s, dict,memo)){
                    return memo[index]=true;
                }
            }
        }
        return memo[index] = false;
    }
}