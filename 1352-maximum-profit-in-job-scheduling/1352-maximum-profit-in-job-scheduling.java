class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n = startTime.length;

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = jobs[i][0];

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int skip = dp[i + 1];

            int next = lowerBound(starts, jobs[i][1]);
            int take = jobs[i][2] + dp[next];

            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}