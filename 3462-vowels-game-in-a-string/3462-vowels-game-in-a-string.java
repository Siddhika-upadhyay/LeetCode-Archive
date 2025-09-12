class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        if (count == 0) return false;
        else return true;
    }
}