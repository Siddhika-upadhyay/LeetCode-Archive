import java.util.Stack;

class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    private long sumSubarrayMin(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int j = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                sum += (long) nums[j] * (j - left) * (i - j);
            }
            stack.push(i);
        }
        
        return sum;
    }

    private long sumSubarrayMax(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int j = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                sum += (long) nums[j] * (j - left) * (i - j);
            }
            stack.push(i);
        }
        
        return sum;
    }
}
