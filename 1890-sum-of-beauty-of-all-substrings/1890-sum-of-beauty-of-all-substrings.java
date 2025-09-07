class Solution {
    public int beautySum(String s) {
         int totalBeauty = 0;
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 
            
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }
                
                totalBeauty += (maxFreq - minFreq);
            }
        }
        
        return totalBeauty;
    }
    
}