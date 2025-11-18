class Solution {
    public static String[] map= {
        " "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String>result= new ArrayList<>();
        if(digits==null||digits.length()==0)return result;
        comb(0,digits,new StringBuilder(),result);
        return result;
    }
    public void comb(int ind, String digits,StringBuilder curr,
    List<String>result){
        if(ind==digits.length()){
            result.add(curr.toString());
            return;
        }
        String letters= map[digits.charAt(ind)-'0'];
        for(char ch: letters.toCharArray()){
            curr.append(ch);
            comb(ind+1,digits,curr,result);
            curr.deleteCharAt(curr.length() - 1); 
        }
    }
}