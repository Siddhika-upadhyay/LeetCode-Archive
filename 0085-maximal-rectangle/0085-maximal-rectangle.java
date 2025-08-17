class Solution {
   
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            if (i < n) st.push(i);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] mat) {
        int maxArea = 0;
        int n = mat.length;
        int m = mat[0].length;

        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
     //   private int largestRectangleArea(int[] heights) {
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
    //          int n = matrix.length;    
    //     int m = matrix[0].length;
    //     int[][] prefixSum = new int[n][m];  
    //     for (int j = 0; j < m; j++) {  
    //         int sum = 0;
    //         for (int i = 0; i < n; i++) {  
    //             if (matrix[i][j] == 0) sum = 0;
    //             else sum += matrix[i][j];  
    //             prefixSum[i][j] = sum;  
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         int maxArea=max(maxArea,largestRectangleArea(prefixSum[i]));
    //     }
    //     return maxArea;
    // }
}