class Solution {
    public boolean isValid(String word) {
        if (word.length()<3) return false;
        int vowel=0;
        int consonant=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
          if(!Character.isLetterOrDigit(ch)){
            return false;
          }
          if("aeiouAEIOU".indexOf(ch)!=-1)vowel++;
          else if(Character.isLetter(ch)&&"aeiouAEIOU".indexOf(ch)==-1)consonant++;
        } 
        if(vowel==0||consonant==0)return false;
        return true;
    }
}