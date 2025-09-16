import java.util.*;

class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int num : nums) {
            while(!stack.isEmpty()) {
                int top = stack.peek();
                int gcdValue = gcd(top, num);
                
                if(gcdValue == 1) {
                    break; 
                }
                num = lcm(top, num);
                stack.pop();
            }
            stack.push(num);
        }
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pollLast());
        }
        
        return result;
    }
}
