class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int i;
        for (i = n - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (digit % 2 != 0) break;
        }

        if (i < 0) return ""; 
        return num.substring(0, i + 1);
    }
}