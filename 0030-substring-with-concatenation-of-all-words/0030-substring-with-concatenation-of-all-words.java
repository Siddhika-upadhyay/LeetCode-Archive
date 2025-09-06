class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
           List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;
        
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        
        if (s.length() < totalLen) return result;
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> window = new HashMap<>();
            
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                if (wordCount.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (window.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return result;
    }
}