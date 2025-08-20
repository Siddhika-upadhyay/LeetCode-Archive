class Solution {
    // memo[mask] = number of ways to complete arrangement from this used-set state
    private int[] memo;
    private int n;
    private int[][] valid; // valid[pos] = array of numbers that can be placed at position pos

    public int countArrangement(int n) {
        this.n = n;
        int size = 1 << n;
        memo = new int[size];
        for (int i = 0; i < size; i++) memo[i] = -1;

        // Precompute valid numbers for each position (1-indexed positions, 1..n)
        valid = new int[n + 1][];
        for (int pos = 1; pos <= n; pos++) {
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            for (int num = 1; num <= n; num++) {
                if (pos % num == 0 || num % pos == 0) list.add(num);
            }
            valid[pos] = list.stream().mapToInt(Integer::intValue).toArray();
        }

        // Start with mask = 0 (no numbers used), at position 1
        return dfs(0, 1);
    }

    private int dfs(int mask, int pos) {
        if (pos > n) return 1;               // placed all positions
        if (memo[mask] != -1) return memo[mask];

        int ways = 0;
        for (int num : valid[pos]) {
            int bit = 1 << (num - 1);
            if ((mask & bit) == 0) {         // if num not used yet
                ways += dfs(mask | bit, pos + 1);
            }
        }
        memo[mask] = ways;
        return ways;
    }
}
