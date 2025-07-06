 class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> parentMap = new HashMap<>(); // child -> list of parents
        Map<String, Integer> stepsMap = new HashMap<>(); // word -> min steps to reach
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        stepsMap.put(beginWord, 1); // beginWord is reached at step 1

        int wordLen = beginWord.length();

        // ✅ STEP 1: BFS to build stepsMap and parentMap
        while (!q.isEmpty()) {
            String word = q.poll();
            int currentStep = stepsMap.get(word);

            char[] wordArr = word.toCharArray();
            for (int i = 0; i < wordLen; i++) {
                char originalChar = wordArr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArr[i] = c;
                    String newWord = new String(wordArr);

                    if (wordSet.contains(newWord)) {
                        // First time seeing this word
                        if (!stepsMap.containsKey(newWord)) {
                            stepsMap.put(newWord, currentStep + 1);
                            q.add(newWord);
                            parentMap.putIfAbsent(newWord, new ArrayList<>());
                            parentMap.get(newWord).add(word);
                        }
                        //Already seen on the same level, still part of shortest path
                        else if (stepsMap.get(newWord) == currentStep + 1) {
                            parentMap.get(newWord).add(word);
                        }
                    }
                }
                wordArr[i] = originalChar; // restore for next index
            }
        }

        //STEP 2: DFS from endWord to beginWord using parentMap
        if (!parentMap.containsKey(endWord)) return result; // no path exists

        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, parentMap, path, result);

        return result;
    }

    //STEP 3: DFS to backtrack from endWord to beginWord
    private void dfs(String current, String beginWord, Map<String, List<String>> parentMap,
                     List<String> path, List<List<String>> result) {
        path.add(current);

        if (current.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath); 
            result.add(validPath);
        } else {
            if (parentMap.containsKey(current)) {
                for (String parent : parentMap.get(current)) {
                    dfs(parent, beginWord, parentMap, path, result);
                }
            }
        }

        path.remove(path.size() - 1); 
    }
}