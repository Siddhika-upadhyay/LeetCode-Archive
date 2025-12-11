class Solution {
     static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i==n-1||j==m-1)&&grid[i][j]==1)
                dfs(i,j,grid,n,m);
            }
        }
        int count=0;
        for( int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)count++;
            }
        }
        return  count;
    }
    public void dfs( int row,int col, int [][]grid,int n, int m){
        grid[row][col]=2;
        for(int i=0;i<4;i++){
            int nr= row+dr[i];
            int nc= col+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]== 1 ){
                dfs(nr,nc,grid,n,m);
            }
        }
    } 
}
