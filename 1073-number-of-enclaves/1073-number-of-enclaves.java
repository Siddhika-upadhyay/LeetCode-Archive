class Solution {
  
       public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                q.add(new int[]{i, 0});
                vis[i][0] = 1;
            }
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                q.add(new int[]{i, m - 1});
                vis[i][m - 1] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                q.add(new int[]{0, j});
                vis[0][j] = 1;
            }
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                q.add(new int[]{n - 1, j});
                vis[n - 1][j] = 1;
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}