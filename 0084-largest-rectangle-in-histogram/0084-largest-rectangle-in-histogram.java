class Solution {
    public int largestRectangleArea(int[] heights) {
         int n= heights.length;
         int leftSmall[]= new int [n];
         int rightSmall[]= new int [n];
         Stack<Integer> st= new Stack<>();
         int maxA=0;
         for(int i=0;i<n;i++){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }
           leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
         }
          while(!st.isEmpty())st.pop();
           for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }
            rightSmall[i]=st.isEmpty()?n-1:st.peek()-1;
            maxA= Math.max(maxA,(rightSmall[i] - leftSmall[i] + 1)*heights[i]);
            st.push(i);
         }
        return maxA;
    }

    // public int largestRectangleArea(int[] heights) {
    //     Stack<Integer> st = new Stack<>();
    //     int n = heights.length;
    //     int maxArea = 0;
    //     for (int i = 0; i < n; i++) {
    //         while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
    //             int element = st.pop();
    //             int nse = i;
    //             int pse = st.isEmpty() ? -1 : st.peek();
    //             maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
    //         }
    //         st.push(i);
    //     }

    //     while (!st.isEmpty()) {
    //         int element = st.pop();
    //         int nse = n;
    //         int pse = st.isEmpty() ? -1 : st.peek();
    //         maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
    //     }

    //     return maxArea;
    // }

    // public int maximalRectangle(char[][] matrix) {
    //     int n = matrix.length;
    //     if (n == 0) return 0; 
    //     int m = matrix[0].length;
    //     int[][] prefixSum = new int[n][m];

    //     for (int j = 0; j < m; j++) {
    //         int sum = 0;
    //         for (int i = 0; i < n; i++) {
    //             if (matrix[i][j] == '0') sum = 0;  
    //             else sum += matrix[i][j] - '0';  
    //             prefixSum[i][j] = sum;
    //         }
    //     }

    //     int maxArea = 0;
    //     for (int i = 0; i < n; i++) {
    //         int[] heights = new int[m + 1];
    //         for (int j = 0; j < m; j++) {
    //             heights[j] = prefixSum[i][j];
    //         }
    //         maxArea = Math.max(maxArea, largestRectangleArea(heights));
    //     }
    //     return maxArea;
    // }
}