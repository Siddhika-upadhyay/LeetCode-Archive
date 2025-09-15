class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
      String[] words= text.split(" ");// (\\s+) any white spaces:
      char []chArray= brokenLetters.toCharArray();
      int countW=0;
      for(String word:words){
        boolean canType=true;
        for(char ch: chArray){
            if(word.indexOf(ch)!=-1){
                canType=false;
                break;
            }
        }
        if(canType)countW++;
      }
      return countW;
    }

}