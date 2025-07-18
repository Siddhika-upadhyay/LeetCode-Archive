class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        int[][] vis = new int[n][n];
        PriorityQueue<int []>pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int dr[]= {-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int time=curr[0];
            int x= curr[1];
            int y= curr[2];
            if(x==n-1&&y==n-1)return time;
            if(vis[x][y]==1)continue;
            vis[x][y]=1;
            for(int i=0;i<4;i++){
                int nx=x+dr[i];
                int ny=y+dc[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<n&&vis[nx][ny]==0){
                    int newTime=Math.max(time,grid[nx][ny]);
                    pq.offer(new int[]{newTime,nx,ny});
                }
            }
        }
        return -1;
    }
}