class Solution {
    public boolean doesAliceWin(String s) {
        // int count = 0;
        // for (char c : s.toCharArray()) {
        //     if ("aeiou".indexOf(c) >= 0) count++;
        // }
        // if (count == 0) return false;
        // else return true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a','e','i','o','u':
                    return true;
            }
        }

        return false;
    }
}