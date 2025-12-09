class Solution {
    class Tuple{
        int row;
        int col;
        int time;
        Tuple(int r, int c, int t){
            this.row=r;
            this.col=c;
            this.time=t;
        }
    }
    public int orangesRotting(int[][] grid) {
      int n= grid.length;
      int m = grid[0].length;
      int vis[][]= new int [n][m];
      int []dr={ -1,0,1,0};
      int []dc= {0,1,0,-1};
      int maxTime=0;
      PriorityQueue<Tuple> pq= new PriorityQueue<>((a,b) -> a.time - b.time);
      int FreshCnt=0;
      for( int i=0;i<n;i++){
        for( int j=0;j<m;j++){
            if(grid[i][j]==2){
                pq.add(new Tuple(i,j,0));
            }
            else if(grid[i][j]==1)FreshCnt++;
        }
      }
      while(!pq.isEmpty()){
        Tuple temp=pq.poll();
        int r= temp.row;
        int c= temp.col;
        int t= temp.time;
        vis[r][c]=1;
        maxTime= Math.max(maxTime, t);
        for( int i=0;i<4;i++){
            int nr= r+dr[i];
            int nc= c+dc[i];
            if(nr>=0 && nc >=0 && nr<n && nc<m && vis[nr][nc]==0 && grid[nr]
            [nc]==1){
                FreshCnt--;
                pq.add(new Tuple(nr,nc,t+1));
                grid[nr][nc] = 2;
            }
        }
      }
      if(FreshCnt!=0)return -1;
      return maxTime;
    
    }
}