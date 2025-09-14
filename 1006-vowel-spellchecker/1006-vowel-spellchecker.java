import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lowerWord = word.toLowerCase();
            caseMap.putIfAbsent(lowerWord, word);

            String vowelKey = devowel(lowerWord);
            vowelMap.putIfAbsent(vowelKey, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }
            String lowerQuery = query.toLowerCase();
            if (caseMap.containsKey(lowerQuery)) {
                result[i] = caseMap.get(lowerQuery);
                continue;
            }
            String vowelKey = devowel(lowerQuery);
            if (vowelMap.containsKey(vowelKey)) {
                result[i] = vowelMap.get(vowelKey);
                continue;
            }

            // 4. No match
            result[i] = "";
        }

        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (isVowel(ch)) {
                sb.append('*');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
