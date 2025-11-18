class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result= new ArrayList<>();
        List<String>path=new ArrayList<>();
        comb(0, s, path,result);
        return result;
    }
    public void comb(int ind, String s, List<String>path, List<List<String>>result){
        if(ind==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                comb(i+1,s,path,result);
                path.remove(path.size()-1);
            }
        }
    }
     boolean isPalindrome(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
         return true;
    }
}