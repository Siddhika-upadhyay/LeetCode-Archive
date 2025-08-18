class Solution {
    // public int maximum69Number (int num) {
    //     String s = String.valueOf(num);
    //     char[] arr = s.toCharArray();
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] == '6') {
    //             arr[i] = '9';
    //             break;  }
    //     }
    //     return Integer.parseInt(new String(arr));
    // }
     public int maximum69Number (int num) {
        int original = num;
        int pos = -1;   
        int place = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 6) {
                pos = place; 
            }
            temp /= 10;
            place++;
        }

        if (pos == -1) return num;
        return original + 3 * (int)Math.pow(10, pos);
    }
}
