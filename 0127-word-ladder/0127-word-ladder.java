class Solution {
    class Pair{
        String word;
        int steps;
        Pair(String w, int s){
            this.word=w;
            this.steps=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n= beginWord.length();
        Set<String> wordSet= new HashSet<>(wordList);
        if(!wordSet.contains(endWord))return 0;
        Queue<Pair>q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair temp= q.poll();
            String word= temp.word;
            int steps= temp.steps;
            if(word.equals(endWord))return steps;
            char[]wordArray= word.toCharArray();
            for(int i=0;i<wordArray.length;i++){
                char originalChar= wordArray[i];
                for(char c='a';c<='z';c++){
                    wordArray[i]=c;
                    String tempString=new String(wordArray);
                    if(wordSet.contains(tempString)){
                        q.add(new Pair(tempString,steps+1));
                         wordSet.remove(tempString);
                    }
                }
                wordArray[i]=originalChar;
            }
        }
        return 0;
    }
}