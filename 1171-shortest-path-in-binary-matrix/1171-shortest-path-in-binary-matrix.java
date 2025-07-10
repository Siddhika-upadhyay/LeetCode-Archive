class Solution {
    class tuple{
        int first,second,third;
        tuple(int f,int s,int t){
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if (n==1 && m==1 && grid[0][0]==0) return 1;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        Queue<tuple>q= new LinkedList<>();
        int dist[][]=new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)dist[i][j]=(int)1e9;
        }
        dist[0][0]=1;
        q.add(new tuple(1,0,0));
      int[] delRow={-1,-1,0,1,1,1,0,-1};
      int[] delCol={0,1,1,1,0,-1,-1,-1};
      while(!q.isEmpty()){
        tuple it=q.peek();
        int dis=it.first;
        int r=it.second;
        int c=it.third;
        q.remove();
        for(int i=0;i<8;i++){
            int newr=r+delRow[i];
            int newc=c+delCol[i];
            if(newr>=0 && newr<n && newc>=0 && newc<m && 
            grid[newr][newc]==0 && dis+1 < dist[newr][newc]){
                dist[newr][newc]=1+dis;
                if(newr==n-1 && newc==n-1){
                    return dis+1;
                }
                q.add(new tuple(1+dis,newr,newc));
            }
        }
      }
     return -1;

    }
}