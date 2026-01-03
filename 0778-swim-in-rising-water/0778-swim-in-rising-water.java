class Pair{
    int row;
    int col;
    int time;
    Pair(int r,int c,int t){
          row=r;
          col=c;
          time=t;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
     PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(0,0,grid[0][0]));
        int maxTime;
        int vis[][]=new int [n][n];
        int[]delRow = {-1,0,1,0};
        int[]delCol = {0,1,0,-1};
        while(!pq.isEmpty()){
            int row=pq.peek().row;
            int col=pq.peek().col;
            int time=pq.peek().time;
            pq.remove();
            if(row==n-1&&col==n-1)return time;
            if(vis[row][col]==1)continue;
            vis[row][col]=1;
            for(int i=0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol= col+delCol[i];
                if(newRow>=0&&newRow<n && newCol>=0&&newCol<n && vis[newRow]
                [newCol]==0){
                     maxTime= Math.max(grid[newRow][newCol],time);
                    pq.add(new Pair(newRow,newCol,maxTime));
                }
            }
         }
         return -1;
    }
}