class Solution {
    public List<String> validStrings(int n) {
        String curr= "";
        List<String>result= new ArrayList<>();
        generate(n,curr,result);
        return result;
    }
    public void  generate(int n, String curr,List<String> result){
        if(curr.length()==n){
        result.add(curr);
        return ;
        }
        generate(n,curr+"1",result);
        if(curr.length()==0||curr.charAt(curr.length()-1)!='0'){
            generate(n,curr+"0",result);
        }
    }
}