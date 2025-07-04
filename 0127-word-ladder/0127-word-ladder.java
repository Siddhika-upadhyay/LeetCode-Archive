class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set= new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        Queue<String>q= new LinkedList<>();
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                String word= q.poll();
            char[] wordArr= word.toCharArray();
            for(int j=0;j< wordArr.length;j++){
              char originalWord=  wordArr[j];
              for(char c='a'; c<='z';c++){
                    wordArr[j]=c;
                  //change this changed wordArr to string:
                  String temp= new String(wordArr);
                  if(temp.equals(endWord))return level+1;
                  if(set.contains(temp)){
                    q.add(temp);
                    set.remove(temp);
                  }
              }
              wordArr[j]=originalWord;
            }
            }
            level++;
        }
        return 0;
    }
}